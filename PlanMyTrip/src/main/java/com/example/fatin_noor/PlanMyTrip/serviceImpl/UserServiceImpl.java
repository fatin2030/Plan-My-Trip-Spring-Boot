package com.example.fatin_noor.PlanMyTrip.serviceImpl;



import com.example.fatin_noor.PlanMyTrip.dto.RegistrationDTO;
import com.example.fatin_noor.PlanMyTrip.dto.ResponseDTO;
import com.example.fatin_noor.PlanMyTrip.entity.Address;
import com.example.fatin_noor.PlanMyTrip.entity.Role;
import com.example.fatin_noor.PlanMyTrip.entity.User;
import com.example.fatin_noor.PlanMyTrip.mapper.UserMapper;
import com.example.fatin_noor.PlanMyTrip.repository.RoleRepository;
import com.example.fatin_noor.PlanMyTrip.repository.UserRepository;

import com.example.fatin_noor.PlanMyTrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public ResponseDTO registerUser(RegistrationDTO registrationDTO){
        if(userRepository.existsByEmail(registrationDTO.getEmail())){
            throw new IllegalStateException("Email already exists");
        }


        Role role = roleRepository.findByRoleName(registrationDTO.getRoleName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid role"));

        Address address = new Address();
        address.setCountry(registrationDTO.getCountry());
        address.setCity(registrationDTO.getCity());
        address.setStreet(registrationDTO.getStreet());

        User user = new User();

        user.setRole(role);
        user.setName(registrationDTO.getName());
        user.setEmail(registrationDTO.getEmail());
        user.setAddress(address);
            // userName, email
        User responseUser =userRepository.save(user);

        return  userMapper.toUserResponseDTO(responseUser);

    }

}
