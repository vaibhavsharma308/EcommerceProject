package com.ecommerce.sb_ecom.dto;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Data
public class CartItemResponse {
    private User user;
    private Product product;
    private Integer quantity;
    private BigDecimal price;
}
