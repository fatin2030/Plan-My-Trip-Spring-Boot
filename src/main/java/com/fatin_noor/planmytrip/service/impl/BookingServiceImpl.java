package com.fatin_noor.planmytrip.service.impl;

import com.fatin_noor.planmytrip.dto.BookingDTO;
import com.fatin_noor.planmytrip.dto.BookingResponseDTO;
import com.fatin_noor.planmytrip.entity.Booking;
import com.fatin_noor.planmytrip.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.entity.User;
import com.fatin_noor.planmytrip.exception.ApiException;
import com.fatin_noor.planmytrip.mapper.BookingMapper;
import com.fatin_noor.planmytrip.repository.BookingRepository;
import com.fatin_noor.planmytrip.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.repository.UserRepository;
import com.fatin_noor.planmytrip.repository.projection.BookingSummaryProjection;
import com.fatin_noor.planmytrip.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

import static com.fatin_noor.planmytrip.enums.Status.ACTIVE;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Transactional
    public BookingResponseDTO tourPackageBooking(Long tourPackageID, Long userID, BookingDTO bookingDTO) {

        // Validate inputs\\
        int value = bookingRepository.countBookingByUserAndTourCategory(userID,tourPackageID);
        if(value > 0 && bookingDTO.getStatus().name().equals(ACTIVE.name())) {
            throw new ApiException("You have already booked this tour package", HttpStatus.BAD_REQUEST);
        }

        TourPackageInfo tourInfo = tourPackageInfoRepository.findById(tourPackageID).orElseThrow(
                () -> new ApiException("Tour Package Not Found", HttpStatus.NOT_FOUND)
        );

        User userInfo = userRepository.findById(userID).orElseThrow(
                ()-> new ApiException("User Not Found",HttpStatus.NOT_FOUND)
        );

        Booking booking = new Booking();

        booking.setUser(userInfo);
        booking.setStatus(bookingDTO.getStatus());
        booking.setBookingDate(LocalDate.now());
        booking.setTourPackageInfo(tourInfo);



        Booking savedBooking = bookingRepository.save(booking);
        return  bookingMapper.toDto(savedBooking);
    }

    public BookingSummaryProjection bookingInfo(Long id) {

       return bookingRepository.bookingInfo(id);
    }

    public List<BookingSummaryProjection> getBookingStat() {
        return this.bookingRepository.getBookingSummary();
    }


}
