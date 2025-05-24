package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.dto.ProductRequest;
import com.ecommerce.sb_ecom.dto.ProductResponse;
import com.ecommerce.sb_ecom.mapper.ProductMapper;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    ProductMapper productMapper;
    @InjectMocks
    ProductService productService;

    ProductRequest createMockProductRequest(){
        ProductRequest product = new ProductRequest();
        product.setName("Sample Product");
        product.setDescription("This is a sample e-commerce product.");
        product.setPrice(new BigDecimal("49.99"));
        product.setStockQuantity("100");
        product.setCategory("Electronics");
        product.setImageUrl("https://example.com/product-image.jpg");
        return product;
    }
    @Test
    void addProductTest(){
        ProductResponse productRespone = new ProductResponse();
        ProductRequest productRequest = createMockProductRequest();
        Product product = productMapper.productRequestToProduct(productRequest);
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(productMapper.productToProductResponse(product)).thenReturn(productRespone);
        ProductResponse actualProductResponse= productService.addProduct(productRequest);
        Assertions.assertEquals(actualProductResponse,productRespone);

    }
}
