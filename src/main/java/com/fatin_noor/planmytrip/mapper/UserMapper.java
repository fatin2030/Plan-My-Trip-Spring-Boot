package com.fatin_noor.planmytrip.mapper;

import com.fatin_noor.planmytrip.user.dto.*;
import com.fatin_noor.planmytrip.user.dto.ResponseDTO;
import com.fatin_noor.planmytrip.user.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    ResponseDTO toUserResponseDTO(User user);

 //   AddressDTO toAddressDTO(Address address);

  //  RoleDTO toRoleDTO(Role role);

    UpdateUserDTO toDto (User user);

    UsersDTO toUserRegistrationDTO(User user);

}
