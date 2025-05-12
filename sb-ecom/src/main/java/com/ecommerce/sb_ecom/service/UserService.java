package com.ecommerce.sb_ecom.service;


import com.ecommerce.sb_ecom.model.User;
import com.ecommerce.sb_ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
       userRepository.save(user);
    }
}
