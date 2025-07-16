package com.example.fatin_noor.PlanMyTrip.service;

import com.example.fatin_noor.PlanMyTrip.dto.BookingDTO;
import com.example.fatin_noor.PlanMyTrip.dto.BookingResponseDTO;
import com.example.fatin_noor.PlanMyTrip.repository.projection.BookingSummaryProjection;

public interface BookingService{
    BookingResponseDTO tourPackageBooking(Long tourPackageId, Long userID, BookingDTO bookingDTO);

    BookingSummaryProjection bookingInfo(Long id);
}
