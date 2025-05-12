package com.ecommerce.sb_ecom.repository;

import com.ecommerce.sb_ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByActiveTrue();
}
