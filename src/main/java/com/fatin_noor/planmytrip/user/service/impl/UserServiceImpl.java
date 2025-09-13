package com.fatin_noor.planmytrip.user.service.impl;



import com.fatin_noor.planmytrip.user.service.UserService;
import com.fatin_noor.planmytrip.user.dto.*;
import com.fatin_noor.planmytrip.user.entity.Address;
import com.fatin_noor.planmytrip.user.entity.Role;
import com.fatin_noor.planmytrip.user.entity.User;
import com.fatin_noor.planmytrip.exception.ApiException;
import com.fatin_noor.planmytrip.mapper.UserMapper;
import com.fatin_noor.planmytrip.user.repository.RoleRepository;
import com.fatin_noor.planmytrip.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }


    public void registerUser(UserRegistrationDTO userRegistrationDTO){
        if(userRepository.existsByEmail(userRegistrationDTO.getEmail())){
            throw new ApiException("Email already exists", HttpStatus.CONFLICT);
        }


        Role role = roleRepository.findByRoleName(userRegistrationDTO.getRoleName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid role"));

        Address address = new Address();
        address.setCountry(userRegistrationDTO.getCountry());
        address.setCity(userRegistrationDTO.getCity());
        address.setStreet(userRegistrationDTO.getStreet());

        User user = new User();

        user.setRole(role);
        user.setName(userRegistrationDTO.getName());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setAddress(address);
            // userName, email
//        User responseUser =
        userRepository.save(user);
//
//        return  userMapper.toUserResponseDTO(responseUser);
    }


    public void updateUser(Long id, UpdateUserDTO updateUserDTO) {

        User userInfo = userRepository.findById(id).orElseThrow(
                () -> new ApiException("User Not Found" , HttpStatus.NOT_FOUND)
        );

        if (updateUserDTO.getName() != null && !updateUserDTO.getName().isBlank()) {
            userInfo.setName(updateUserDTO.getName());
        }


        if (updateUserDTO.getEmail() != null && !updateUserDTO.getEmail().isBlank()) {
            userInfo.setEmail(updateUserDTO.getEmail());
        }
          Address addressInfo =  userInfo.getAddress();

        if (updateUserDTO.getCountry() != null && !updateUserDTO.getCountry().isBlank()) {
            addressInfo.setCountry(updateUserDTO.getCountry());
        }
        if (updateUserDTO.getCity() != null && !updateUserDTO.getCity().isBlank()) {
            addressInfo.setCity(updateUserDTO.getCity());
        }
        if (updateUserDTO.getStreet() != null && !updateUserDTO.getStreet().isBlank()) {
            addressInfo.setStreet(updateUserDTO.getStreet());
        }

        userInfo.setAddress(addressInfo);
        userRepository.save(userInfo);
    }


    public List<UsersDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UsersDTO> dtoList = new ArrayList<>();

        if (users.isEmpty()) {
            throw new ApiException("No users found", HttpStatus.NOT_FOUND);
        }
        for(User user: users){
            dtoList.add(userMapper.toUserRegistrationDTO(user));
        }
        return dtoList;
    }
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ApiException("User Not Found", HttpStatus.NOT_FOUND));

        userRepository.delete(user);
    }
}
