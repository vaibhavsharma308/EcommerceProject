package com.ecommerce.sb_ecom.dto;


import lombok.Data;

@Data
public class CartItemRequest {
    private Long productId;
    private Integer quantity;

}
