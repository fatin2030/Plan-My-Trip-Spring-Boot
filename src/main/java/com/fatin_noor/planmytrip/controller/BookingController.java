package com.fatin_noor.planmytrip.controller;

import com.fatin_noor.planmytrip.dto.BookingDTO;
import com.fatin_noor.planmytrip.dto.BookingResponseDTO;
import com.fatin_noor.planmytrip.repository.projection.BookingSummaryProjection;
import com.fatin_noor.planmytrip.service.impl.BookingServiceImpl;
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

    @GetMapping("/summary")
    public List<BookingSummaryProjection> getBookingSummary() {
        return bookingService.getBookingStat();
    }


}
