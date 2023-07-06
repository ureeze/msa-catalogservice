package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.dto.ResponseOrder;
import com.example.orderservice.messagequeue.KafkaProducer;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {
    private final OrderService orderService;
    private final Environment environment;
    private final KafkaProducer kafkaProducer;

    /*
    userId, 카탈로그 정보를 통한 주문 생성
     */
    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable("userId") String userId,
                                                     @RequestBody RequestOrder orderDetails) {

        /*
        JPA
         */
        OrderDto orderDto = orderDetails.toOrderDto();
        orderDto.updateUserId(userId);

        ResponseOrder responseOrder = new ResponseOrder(orderService.createOrder(orderDto));

        /*
        SEND THIS ORDER TO THE KAFKA
         */
        kafkaProducer.send("example-catalog-topic", orderDto);

        return ResponseEntity.ok(responseOrder);
    }

    /*
    userId를 통한 주문 정보 조회
     */
    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId).stream()
                .map(orderDto -> new ResponseOrder(orderDto))
                .collect(Collectors.toList()));
    }


    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Order Service on PORT %s",
                environment.getProperty("local.server.port"));
    }
}
