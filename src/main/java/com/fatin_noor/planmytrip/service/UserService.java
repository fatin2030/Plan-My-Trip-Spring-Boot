package com.fatin_noor.planmytrip.service;

import com.fatin_noor.planmytrip.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.dto.UserRegistrationDTO;
import com.fatin_noor.planmytrip.dto.ResponseDTO;

public interface UserService {

    ResponseDTO registerUser(UserRegistrationDTO userRegistrationDTO);

    ResponseDTO updateUser(Long id, UpdateUserDTO updateUserDTO);
}
