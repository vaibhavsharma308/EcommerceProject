package com.ecommerce.sb_ecom.service;


import com.ecommerce.sb_ecom.dto.CartItemRequest;
import com.ecommerce.sb_ecom.dto.CartItemResponse;
import com.ecommerce.sb_ecom.mapper.CartMapper;
import com.ecommerce.sb_ecom.model.CartItem;
import com.ecommerce.sb_ecom.model.Product;
import com.ecommerce.sb_ecom.model.User;
import com.ecommerce.sb_ecom.repository.CartItemRepository;
import com.ecommerce.sb_ecom.repository.ProductRepository;
import com.ecommerce.sb_ecom.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CartService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final CartMapper cartMapper;

    public CartService(UserRepository userRepository, ProductRepository productRepository, CartItemRepository cartItemRepository, CartMapper cartMapper) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartMapper = cartMapper;
    }


    public Boolean addToCart(String userId, CartItemRequest request) {
        Long productId = request.getProductId();
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            return false;
        }
        Product product = productOpt.get();
        int requestQuantity = request.getQuantity();
        int availableQuantity = Integer.parseInt(product.getStockQuantity());
        if (requestQuantity >= availableQuantity) {
            return false;
        }
        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if (userOpt.isEmpty()) {
            return false;
        }
        User user = userOpt.get();
        CartItem existingCart = cartItemRepository.findByUserAndProduct(user, product);
        if (existingCart != null) {
            int newQuantity = existingCart.getQuantity() + requestQuantity;
            BigDecimal productPrice = product.getPrice();
            BigDecimal newPrice = productPrice.multiply(BigDecimal.valueOf(requestQuantity));
            existingCart.setQuantity(newQuantity);
            existingCart.setPrice(newPrice);
            product.setStockQuantity(String.valueOf(availableQuantity - requestQuantity));
            productRepository.save(product);
        } else {
            CartItem cart = new CartItem();
            BigDecimal productPrice = product.getPrice();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setPrice(productPrice);
            cart.setQuantity(requestQuantity);
            cart.setProduct(product);
            cartItemRepository.save(cart);
            product.setStockQuantity(String.valueOf(availableQuantity - requestQuantity));
            productRepository.save(product);
        }
        return true;
    }

    public boolean removeItem(String userId, Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            return false;
        }
        Product product = productOpt.get();
        Long uId = Long.valueOf(userId);
        Optional<User> userOpt = userRepository.findById(uId);
        if (userOpt.isEmpty()) {
            return false;
        }
        User user = userOpt.get();
        CartItem existingCart = cartItemRepository.findByUserAndProduct(user, product);
        if (existingCart != null) {
            cartItemRepository.deleteByUserAndProduct(user, product);
            return true;
        }
        return false;
    }

    public List<CartItemResponse> getUserCartItems(String userId) {
        Long uId = Long.valueOf(userId);
        Optional<User> userOpt = userRepository.findById(uId);
        if (userOpt.isEmpty()) {
            return Collections.emptyList();  // return empty list if user not found
        }
        User user = userOpt.get();
        List<CartItem> cartItems = cartItemRepository.findAllByUser(user);

        return cartItems.stream()
                .map(cartMapper::cartItemToCartResponse)
                .collect(Collectors.toList());
    }

}
