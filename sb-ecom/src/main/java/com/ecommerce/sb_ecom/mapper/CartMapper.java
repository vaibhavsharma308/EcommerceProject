package com.ecommerce.sb_ecom.mapper;

import com.ecommerce.sb_ecom.dto.CartItemResponse;
import com.ecommerce.sb_ecom.model.CartItem;
import org.springframework.stereotype.Component;




@Component
public class CartMapper {


    public CartItemResponse cartItemToCartResponse(CartItem cartItem) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        cartItemResponse.setUser(cartItem.getUser());
        cartItemResponse.setProduct(cartItem.getProduct());
        cartItemResponse.setQuantity(cartItem.getQuantity());
        cartItemResponse.setPrice(cartItem.getPrice());
        return cartItemResponse;
    }
}
