package com.fatin_noor.planmytrip.user.controller;


import com.fatin_noor.planmytrip.user.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.user.dto.UsersDTO;
import com.fatin_noor.planmytrip.user.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

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
