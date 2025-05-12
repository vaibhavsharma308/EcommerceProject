package com.ecommerce.sb_ecom.repository;

import com.ecommerce.sb_ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
