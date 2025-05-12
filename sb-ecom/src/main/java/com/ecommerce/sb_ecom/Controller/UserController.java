package com.ecommerce.sb_ecom.Controller;


import com.ecommerce.sb_ecom.model.User;
import com.ecommerce.sb_ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("api/users")
    public List<Integer> getUsers(){
        List<Integer> arr = new ArrayList<Integer>();
        return arr;
    }

    @PostMapping("api/createUser")
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "User added Successfully";
    }
}
