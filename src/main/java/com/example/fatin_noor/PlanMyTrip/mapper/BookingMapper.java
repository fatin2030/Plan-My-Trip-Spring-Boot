package com.example.fatin_noor.PlanMyTrip.mapper;
import com.example.fatin_noor.PlanMyTrip.dto.BookingDTO;
import com.example.fatin_noor.PlanMyTrip.dto.BookingResponseDTO;
import com.example.fatin_noor.PlanMyTrip.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toEntity(BookingDTO bookingDTO);

    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "user.email", target = "email")
    BookingResponseDTO toDto (Booking book);
}
