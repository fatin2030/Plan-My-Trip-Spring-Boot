package com.example.fatin_noor.PlanMyTrip.service;

import com.example.fatin_noor.PlanMyTrip.dto.UpdateUserDTO;
import com.example.fatin_noor.PlanMyTrip.dto.UserRegistrationDTO;
import com.example.fatin_noor.PlanMyTrip.dto.ResponseDTO;

public interface UserService {

    ResponseDTO registerUser(UserRegistrationDTO userRegistrationDTO);

    ResponseDTO updateUser(Long id, UpdateUserDTO updateUserDTO);
}
