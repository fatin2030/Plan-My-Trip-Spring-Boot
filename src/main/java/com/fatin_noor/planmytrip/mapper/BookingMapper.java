package com.fatin_noor.planmytrip.mapper;
import com.fatin_noor.planmytrip.booking.dto.BookingDTO;
import com.fatin_noor.planmytrip.user.dto.BookingResponseDTO;
import com.fatin_noor.planmytrip.booking.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking toEntity(BookingDTO bookingDTO);

    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "user.email", target = "email")
    BookingResponseDTO toDto (Booking book);
}
