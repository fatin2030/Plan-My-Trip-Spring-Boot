package com.fatin_noor.planmytrip.service;

import com.fatin_noor.planmytrip.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.dto.UserRegistrationDTO;
import com.fatin_noor.planmytrip.dto.ResponseDTO;
import com.fatin_noor.planmytrip.dto.UsersDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    void updateUser(Long id, UpdateUserDTO updateUserDTO);

    List<UsersDTO> getAllUsers();

    void deleteUser(Long id);

}
