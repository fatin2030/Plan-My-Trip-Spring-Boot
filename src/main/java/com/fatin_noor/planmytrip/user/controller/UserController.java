package com.fatin_noor.planmytrip.user.controller;


import com.fatin_noor.planmytrip.user.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.user.dto.UserRegistrationDTO;
import com.fatin_noor.planmytrip.user.dto.UsersDTO;
import com.fatin_noor.planmytrip.user.service.UserService;
import com.fatin_noor.planmytrip.user.service.impl.UserServiceImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")

    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserRegistrationDTO user){
        userService.registerUser(user);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@Valid @PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO){
         userService.updateUser(id,updateUserDTO);
         return ResponseEntity.status(204).build();
    }

    @GetMapping("/get-all-users")
    public List<UsersDTO> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(204).build();
    }

}
