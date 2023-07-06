package com.example.catalogservice.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog implements Serializable {
    private String productID;
    private String productName;
    private Integer stock;
    private Integer unitPrice;
    private Date createdAt;

    public ResponseCatalog(CatalogDto dto) {
        this.productID = dto.getProductId();
        this.productName = dto.getProductName();
        this.stock = dto.getQty();
        this.unitPrice = dto.getUnitPrice();
    }
}
