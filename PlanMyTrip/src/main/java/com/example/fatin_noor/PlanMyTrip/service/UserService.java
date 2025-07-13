package com.example.fatin_noor.PlanMyTrip.service;

import com.example.fatin_noor.PlanMyTrip.dto.RegistrationDTO;
import com.example.fatin_noor.PlanMyTrip.dto.ResponseDTO;

public interface UserService {

    ResponseDTO registerUser(RegistrationDTO registrationDTO);
}
