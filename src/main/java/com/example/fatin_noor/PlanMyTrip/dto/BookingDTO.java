package com.example.fatin_noor.PlanMyTrip.dto;
import com.example.fatin_noor.PlanMyTrip.entity.User;
import com.example.fatin_noor.PlanMyTrip.enums.Status;
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
