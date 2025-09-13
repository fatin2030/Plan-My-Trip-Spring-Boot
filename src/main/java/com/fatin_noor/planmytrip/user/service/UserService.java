package com.fatin_noor.planmytrip.user.service;

import com.fatin_noor.planmytrip.user.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.user.dto.UserRegistrationDTO;
import com.fatin_noor.planmytrip.user.dto.UsersDTO;

import java.util.List;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    void updateUser(Long id, UpdateUserDTO updateUserDTO);

    List<UsersDTO> getAllUsers();

    void deleteUser(Long id);

}
