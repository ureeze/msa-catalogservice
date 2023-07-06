package com.example.catalogservice;

import com.example.catalogservice.entity.Catalog;
import com.example.catalogservice.entity.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class CatalogServiceApplication implements CommandLineRunner {

    @Autowired
    private CatalogRepository catalogRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        catalogRepository.saveAll(
                List.of(
                        Catalog.builder().productId("CATALOG-0001")
                                .productName("Berlin")
                                .stock(100)
                                .unitPrice(1500)
                                .build(),
                        Catalog.builder().productId("CATALOG-0002")
                                .productName("Tokyo")
                                .stock(100)
                                .unitPrice(900)
                                .build(),
                        Catalog.builder().productId("CATALOG-0003")
                                .productName("Stockholm")
                                .stock(100)
                                .unitPrice(1200)
                                .build()
                )
        );
    }
}