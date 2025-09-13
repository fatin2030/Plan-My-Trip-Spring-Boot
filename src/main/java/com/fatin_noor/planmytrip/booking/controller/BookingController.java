package com.fatin_noor.planmytrip.booking.controller;

import com.fatin_noor.planmytrip.booking.dto.BookingDTO;
import com.fatin_noor.planmytrip.booking.repository.projection.BookingSummaryProjection;
import com.fatin_noor.planmytrip.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/book/{packageId}/user/{userId}")
    public ResponseEntity<Void> createBooking(
            @PathVariable Long packageId,
            @PathVariable Long userId,
            @Valid @RequestBody BookingDTO request
    ) {
        bookingService.tourPackageBooking(packageId, userId, request);
        return ResponseEntity.status(201).build();
    }


    @GetMapping("/get-info/{id}")

    public ResponseEntity<BookingSummaryProjection> bookingInfo(@PathVariable Long id){
         return ResponseEntity.status(HttpStatus.FOUND).body(bookingService.bookingInfo(id));
    }

//    @GetMapping("/summary")
//    public List<BookingSummaryProjection> getBookingSummary() {
//        return bookingService.getBookingStat();
//    }

    @GetMapping("/all-bookings")
    public ResponseEntity<List<BookingSummaryProjection>> getAllBookingInfo() {
        List<BookingSummaryProjection> bookingList = bookingService.getALlBookingInfo();
        return ResponseEntity.ok(bookingList);
    }


}
