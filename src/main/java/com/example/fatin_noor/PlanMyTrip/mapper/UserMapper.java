package com.example.fatin_noor.PlanMyTrip.mapper;

import com.example.fatin_noor.PlanMyTrip.dto.*;
import com.example.fatin_noor.PlanMyTrip.entity.*;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    ResponseDTO toUserResponseDTO(User user);

 //   AddressDTO toAddressDTO(Address address);

  //  RoleDTO toRoleDTO(Role role);

}
