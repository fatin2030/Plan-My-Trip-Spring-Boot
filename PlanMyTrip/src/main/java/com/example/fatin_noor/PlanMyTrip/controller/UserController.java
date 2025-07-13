package com.example.fatin_noor.PlanMyTrip.controller;


import com.example.fatin_noor.PlanMyTrip.dto.RegistrationDTO;
import com.example.fatin_noor.PlanMyTrip.dto.ResponseDTO;
import com.example.fatin_noor.PlanMyTrip.serviceImpl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("api/create")

    public ResponseDTO registerUser(@RequestBody RegistrationDTO user){
        return userService.registerUser(user);
    }

}
