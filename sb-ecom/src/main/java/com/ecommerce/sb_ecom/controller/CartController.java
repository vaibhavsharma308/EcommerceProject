package com.ecommerce.sb_ecom.controller;


import com.ecommerce.sb_ecom.dto.CartItemRequest;
import com.ecommerce.sb_ecom.model.CartItem;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cart")
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping
    public ResponseEntity<Boolean> addCartItem(
            @RequestHeader("USERID") String userId,
            @RequestBody CartItemRequest request
            ){
        cartService.addToCart(userId,request);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
