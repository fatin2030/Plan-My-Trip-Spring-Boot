package com.fatin_noor.planmytrip.serviceImpl;

import com.fatin_noor.planmytrip.dto.BookingDTO;
import com.fatin_noor.planmytrip.dto.BookingResponseDTO;
import com.fatin_noor.planmytrip.entity.Booking;
import com.fatin_noor.planmytrip.entity.TourPackageInfo;
import com.fatin_noor.planmytrip.entity.User;
import com.fatin_noor.planmytrip.exception.ApiException;
import com.fatin_noor.planmytrip.mapper.BookingMapper;
import com.fatin_noor.planmytrip.mapper.TourPackageMapper;
import com.fatin_noor.planmytrip.repository.BookingRepository;
import com.fatin_noor.planmytrip.repository.TourPackageInfoRepository;
import com.fatin_noor.planmytrip.repository.UserRepository;
import com.fatin_noor.planmytrip.repository.projection.BookingSummaryProjection;
import com.fatin_noor.planmytrip.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final TourPackageInfoRepository tourPackageInfoRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final TourPackageMapper tourPackageMapper;

    public BookingResponseDTO tourPackageBooking(Long tourPackageID, Long userID, BookingDTO bookingDTO) {

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

        bookingRepository.save(booking);
        return  bookingMapper.toDto(booking);
    }

    public BookingSummaryProjection bookingInfo(Long id) {
       return bookingRepository.bookingInfo(id);
    }


}
