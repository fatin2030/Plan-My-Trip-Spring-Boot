package com.example.fatin_noor.PlanMyTrip.serviceImpl;



import com.example.fatin_noor.PlanMyTrip.dto.UpdateUserDTO;
import com.example.fatin_noor.PlanMyTrip.dto.UserRegistrationDTO;
import com.example.fatin_noor.PlanMyTrip.dto.ResponseDTO;
import com.example.fatin_noor.PlanMyTrip.entity.Address;
import com.example.fatin_noor.PlanMyTrip.entity.Role;
import com.example.fatin_noor.PlanMyTrip.entity.User;
import com.example.fatin_noor.PlanMyTrip.exception.ApiException;
import com.example.fatin_noor.PlanMyTrip.mapper.UserMapper;
import com.example.fatin_noor.PlanMyTrip.repository.RoleRepository;
import com.example.fatin_noor.PlanMyTrip.repository.UserRepository;

import com.example.fatin_noor.PlanMyTrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


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


    public ResponseDTO registerUser(UserRegistrationDTO userRegistrationDTO){
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
        User responseUser =userRepository.save(user);

        return  userMapper.toUserResponseDTO(responseUser);
    }


    public ResponseDTO updateUser(Long id, UpdateUserDTO updateUserDTO) {

        User userInfo = userRepository.findById(id).orElseThrow(
                () -> new ApiException("User Not Found" , HttpStatus.NOT_FOUND)
        );

        if(!updateUserDTO.getName().isBlank()){
            userInfo.setName(updateUserDTO.getName());
        }
        if(!updateUserDTO.getEmail().isBlank()){
            userInfo.setEmail(updateUserDTO.getEmail());
        }
          Address addressInfo =  userInfo.getAddress();

        if(!addressInfo.getCountry().isBlank()){
            addressInfo.setCountry(updateUserDTO.getCountry());
        }
        if(!addressInfo.getCity().isBlank()){
            addressInfo.setCity(updateUserDTO.getCity());
        }
        if(!addressInfo.getStreet().isBlank()){
            addressInfo.setStreet(updateUserDTO.getStreet());
        }
        userInfo.setAddress(addressInfo);
        userRepository.save(userInfo);
        return userMapper.toUserResponseDTO(userInfo);
    }


}
