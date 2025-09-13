package com.fatin_noor.planmytrip.booking.service;

import com.fatin_noor.planmytrip.booking.dto.BookingDTO;
import com.fatin_noor.planmytrip.booking.dto.BookingDTO;
import com.fatin_noor.planmytrip.booking.repository.projection.BookingSummaryProjection;
import jakarta.validation.Valid;

import java.util.List;

public interface BookingService{
    void tourPackageBooking(Long tourPackageId, Long userID, @Valid BookingDTO bookingDTO);

    BookingSummaryProjection bookingInfo(Long id);

   // BookingSummaryProjection getBookingStat();

    List<BookingSummaryProjection> getALlBookingInfo();

}
