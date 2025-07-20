package com.fatin_noor.planmytrip.dto;
import com.fatin_noor.planmytrip.entity.User;
import com.fatin_noor.planmytrip.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {
    private User user;
    private TourPackageInfoDTO tourPackageInfo;
    private LocalDate bookingDate;


    @NotNull(message = "Booking Status can't Null")
    private Status status;
}
