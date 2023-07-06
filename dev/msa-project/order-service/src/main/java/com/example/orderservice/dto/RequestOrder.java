package com.example.orderservice.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class RequestOrder implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;


    public OrderDto toOrderDto() {
        return OrderDto.builder()
                .productId(productId)
                .qty(qty)
                .unitPrice(unitPrice)
                .totalPrice(qty * unitPrice)
                .orderId(UUID.randomUUID().toString())
                .build();
    }
}
