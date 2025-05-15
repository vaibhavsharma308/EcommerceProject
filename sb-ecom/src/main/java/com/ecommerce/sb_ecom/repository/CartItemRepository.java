package com.ecommerce.sb_ecom.repository;


import com.ecommerce.sb_ecom.model.CartItem;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    CartItem findByUserAndProduct(User user, Product product);
    void deleteByUserAndProduct(User user, Product product);
    List<CartItem> findAllByUser(User user);
}
