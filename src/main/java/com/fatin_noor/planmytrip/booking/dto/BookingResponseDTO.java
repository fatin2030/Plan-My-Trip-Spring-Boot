package com.fatin_noor.planmytrip.user.dto;

import com.fatin_noor.planmytrip.enums.Status;
import com.fatin_noor.planmytrip.tourpackege.dto.TourPackageInfoDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingResponseDTO {

    private String userName;
    private String email;
    private TourPackageInfoDTO tourPackageInfo;
    private LocalDate bookingDate;

    @NotNull(message = "Booking Status can't Null")
    private Status status;

}
