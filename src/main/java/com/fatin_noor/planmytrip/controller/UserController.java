package com.fatin_noor.planmytrip.controller;


import com.fatin_noor.planmytrip.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.dto.UserRegistrationDTO;
import com.fatin_noor.planmytrip.dto.ResponseDTO;
import com.fatin_noor.planmytrip.service.impl.UserServiceImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")

public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")

    public ResponseDTO registerUser(@Valid @RequestBody UserRegistrationDTO user){
        return userService.registerUser(user);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateUser(@Valid @PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO){
        return this.userService.updateUser(id,updateUserDTO);
    }

}
