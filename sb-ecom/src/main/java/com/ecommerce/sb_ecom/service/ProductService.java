package com.ecommerce.sb_ecom.service;
import com.ecommerce.sb_ecom.dto.ProductRequest;
import com.ecommerce.sb_ecom.dto.ProductResponse;
import com.ecommerce.sb_ecom.mapper.ProductMapper;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductService(ProductRepository productRepository,ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product =productMapper.productRequestToProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductResponse(savedProduct);
    }

    public List<ProductResponse> fetchProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(productMapper::productToProductResponse)
                .toList();
    }

    public ProductResponse productById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return productMapper.productToProductResponse(product);
    }

    public List<ProductResponse> fetchActiveProducts()
    {
                   return  productRepository.findByActiveTrue().stream()
                            .map(productMapper::productToProductResponse).toList();
    }
}
