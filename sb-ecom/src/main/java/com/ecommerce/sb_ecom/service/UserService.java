package com.ecommerce.sb_ecom.service;


import com.ecommerce.sb_ecom.dto.UserResponse;
import com.ecommerce.sb_ecom.mapper.UserMapper;
import com.ecommerce.sb_ecom.model.User;
import com.ecommerce.sb_ecom.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<UserResponse> getUsers() {
        return Optional.of(userRepository.findAll()).orElse(Collections.emptyList()).stream().map(UserMapper::userToUserResponse).toList();
    }

    public UserResponse getUserById(Long id) {
        return userRepository.findById(id).map(UserMapper::userToUserResponse)  // Mapping to UserResponse
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));  // Exception if not found
    }
}
