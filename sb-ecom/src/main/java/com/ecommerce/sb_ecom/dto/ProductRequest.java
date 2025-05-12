package com.ecommerce.sb_ecom.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private String stockQuantity;
    private String category;
    private String imageUrl;
}
