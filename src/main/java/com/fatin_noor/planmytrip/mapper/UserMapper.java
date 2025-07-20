package com.fatin_noor.planmytrip.mapper;

import com.fatin_noor.planmytrip.dto.*;
import com.fatin_noor.planmytrip.entity.*;
import com.fatin_noor.planmytrip.dto.ResponseDTO;
import com.fatin_noor.planmytrip.dto.UpdateUserDTO;
import com.fatin_noor.planmytrip.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    ResponseDTO toUserResponseDTO(User user);

 //   AddressDTO toAddressDTO(Address address);

  //  RoleDTO toRoleDTO(Role role);

    UpdateUserDTO toDto (User user);

}
