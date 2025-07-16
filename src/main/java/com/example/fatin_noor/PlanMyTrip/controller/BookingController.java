package com.example.fatin_noor.PlanMyTrip.controller;

import com.example.fatin_noor.PlanMyTrip.dto.BookingDTO;
import com.example.fatin_noor.PlanMyTrip.dto.BookingResponseDTO;
import com.example.fatin_noor.PlanMyTrip.repository.projection.BookingSummaryProjection;
import com.example.fatin_noor.PlanMyTrip.serviceImpl.BookingServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServiceImpl bookingService;

    @PostMapping("/book/{packageId}/user/{userId}")
    public ResponseEntity<BookingResponseDTO> createBooking(
            @PathVariable Long packageId,
            @PathVariable Long userId,
            @Valid @RequestBody BookingDTO request
    ) {
        BookingResponseDTO response = bookingService.tourPackageBooking(packageId, userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get-info/{id}")

    public ResponseEntity<BookingSummaryProjection> bookingInfo(@PathVariable Long id){
         return ResponseEntity.status(HttpStatus.FOUND).body(bookingService.bookingInfo(id));
    }


}
