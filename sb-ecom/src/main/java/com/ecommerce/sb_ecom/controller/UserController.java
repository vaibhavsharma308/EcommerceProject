package com.ecommerce.sb_ecom.controller;


import com.ecommerce.sb_ecom.dto.UserResponse;
import com.ecommerce.sb_ecom.model.User;
import com.ecommerce.sb_ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("api/user/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
    @GetMapping("api/users")
    public ResponseEntity<List<UserResponse>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("api/createUser")
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "User added Successfully";
    }


}
