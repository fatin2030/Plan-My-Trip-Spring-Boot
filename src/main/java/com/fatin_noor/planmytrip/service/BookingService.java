package com.fatin_noor.planmytrip.service;

import com.fatin_noor.planmytrip.dto.BookingDTO;
import com.fatin_noor.planmytrip.dto.BookingResponseDTO;
import com.fatin_noor.planmytrip.repository.projection.BookingSummaryProjection;

import java.util.List;

public interface BookingService{
    void tourPackageBooking(Long tourPackageId, Long userID, BookingDTO bookingDTO);

    BookingSummaryProjection bookingInfo(Long id);

   // BookingSummaryProjection getBookingStat();

    List<BookingSummaryProjection> getALlBookingInfo();

}
