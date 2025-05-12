package com.ecommerce.sb_ecom.controller;


import com.ecommerce.sb_ecom.dto.ProductRequest;
import com.ecommerce.sb_ecom.dto.ProductResponse;
import com.ecommerce.sb_ecom.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("api/products")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse =productService.addProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
    @GetMapping("api/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> products = productService.fetchProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
