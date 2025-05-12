package com.ecommerce.sb_ecom.mapper;


import com.ecommerce.sb_ecom.dto.ProductRequest;
import com.ecommerce.sb_ecom.dto.ProductResponse;
import com.ecommerce.sb_ecom.model.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    public Product productRequestToProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setImageUrl(productRequest.getImageUrl());
        product.setStockQuantity(productRequest.getStockQuantity());
        return product;
    }
    public ProductResponse productToProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setCategory(product.getCategory());
        productResponse.setPrice(product.getPrice());
        productResponse.setImageUrl(product.getImageUrl());
        productResponse.setStockQuantity(product.getStockQuantity());
        return productResponse;
    }
}
