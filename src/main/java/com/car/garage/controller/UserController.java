package com.car.garage.controller;

import com.car.garage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth" )
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

//    @PostMapping("/register")
//    public User createUser(@RequestBody User userObject) {
//        System.out.println("calling createManager ==>");
//        return userService.createUser(userObject);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginManager(@RequestBody LoginRequest loginRequest) {
//        System.out.println("calling loginManager ==>");
//        return userService.loginUser(loginRequest);
//    }

}
