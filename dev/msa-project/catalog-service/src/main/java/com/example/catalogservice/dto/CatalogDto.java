package com.example.catalogservice.dto;

import com.example.catalogservice.entity.Catalog;
import lombok.Getter;

@Getter
public class CatalogDto {
    private String productId;
    private String productName;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public CatalogDto(Catalog catalog) {
        this.productId = catalog.getProductId();
        this.productName = catalog.getProductName();
        this.qty = catalog.getStock();
        this.unitPrice = catalog.getUnitPrice();
        this.totalPrice = this.qty * this.unitPrice;
    }
}
