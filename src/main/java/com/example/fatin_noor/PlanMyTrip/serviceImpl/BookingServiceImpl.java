package com.example.fatin_noor.PlanMyTrip.serviceImpl;

import com.example.fatin_noor.PlanMyTrip.dto.BookingDTO;
import com.example.fatin_noor.PlanMyTrip.dto.BookingResponseDTO;
import com.example.fatin_noor.PlanMyTrip.entity.Booking;
import com.example.fatin_noor.PlanMyTrip.entity.TourPackageInfo;
import com.example.fatin_noor.PlanMyTrip.entity.User;
import com.example.fatin_noor.PlanMyTrip.exception.ApiException;
import com.example.fatin_noor.PlanMyTrip.mapper.BookingMapper;
import com.example.fatin_noor.PlanMyTrip.mapper.TourPackageMapper;
import com.example.fatin_noor.PlanMyTrip.repository.BookingRepository;
import com.example.fatin_noor.PlanMyTrip.repository.TourPackageInfoRepository;
import com.example.fatin_noor.PlanMyTrip.repository.UserRepository;
import com.example.fatin_noor.PlanMyTrip.repository.projection.BookingSummaryProjection;
import com.example.fatin_noor.PlanMyTrip.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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

//        bookingDTO.setUserName(userInfo.getName());
//        bookingDTO.setEmail(userInfo.getEmail());
//        bookingDTO.setTourPackageInfo(tourPackageMapper.toDto(tourInfo));
//        BeanUtils.copyProperties(booking,bookingDTO);

        bookingRepository.save(booking);
        return  bookingMapper.toDto(booking);

    }

    public BookingSummaryProjection bookingInfo(Long id) {
       return bookingRepository.bookingInfo(id);
    }


}
