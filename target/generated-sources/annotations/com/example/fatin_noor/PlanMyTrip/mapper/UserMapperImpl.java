package com.example.fatin_noor.PlanMyTrip.mapper;

import com.example.fatin_noor.PlanMyTrip.dto.AddressDTO;
import com.example.fatin_noor.PlanMyTrip.dto.ResponseDTO;
import com.example.fatin_noor.PlanMyTrip.dto.RoleDTO;
import com.example.fatin_noor.PlanMyTrip.entity.Address;
import com.example.fatin_noor.PlanMyTrip.entity.Role;
import com.example.fatin_noor.PlanMyTrip.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-14T15:17:14+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public ResponseDTO toUserResponseDTO(User user) {
        if ( user == null ) {
            return null;
        }

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setName( user.getName() );
        responseDTO.setEmail( user.getEmail() );
        responseDTO.setAddress( addressToAddressDTO( user.getAddress() ) );
        responseDTO.setRole( roleToRoleDTO( user.getRole() ) );

        return responseDTO;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCountry( address.getCountry() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setStreet( address.getStreet() );

        return addressDTO;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRoleName( role.getRoleName() );

        return roleDTO;
    }
}
