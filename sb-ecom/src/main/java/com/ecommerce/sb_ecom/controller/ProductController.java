package com.ecommerce.sb_ecom.controller;
import com.ecommerce.sb_ecom.dto.ProductRequest;
import com.ecommerce.sb_ecom.dto.ProductResponse;
import com.ecommerce.sb_ecom.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("api/products/{id}")
    public ResponseEntity<ProductResponse> productById(@PathVariable Long id){
        ProductResponse productResponse =productService.productById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
    @GetMapping("/api/products/available")
    public ResponseEntity<List<ProductResponse>> activeProducts(@RequestParam Boolean active){
        List<ProductResponse> products = productService.fetchActiveProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @DeleteMapping("api/products/{id}")
    public ResponseEntity<List<ProductResponse>> deleteProducts(@PathVariable Long id){
        List<ProductResponse> products = productService.removeProduct(id);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}


