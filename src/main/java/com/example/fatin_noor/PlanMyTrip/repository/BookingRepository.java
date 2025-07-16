package com.example.fatin_noor.PlanMyTrip.repository;

import com.example.fatin_noor.PlanMyTrip.dto.ResponseDTO;
import com.example.fatin_noor.PlanMyTrip.entity.Booking;
import com.example.fatin_noor.PlanMyTrip.repository.projection.BookingSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository <Booking,Long > {

    @Query(value = """
            select
                        u.name as userName ,
                        t1.tour_package_name as tourPackageName,
                        t.tour_category as category,
                        t.package_price as packagePrice,
                        t.allowed_person as allowedPerson,
                        t1.description as description,
                        t1.start_data as startDate
                        FROM booking b left join tour_package_info t on b.tour_info_id = t.tour_category_id left join tour_packages t1 on
                        t.tour_package_id = t1.id left join users u on b.user_id = u.user_id
                        where b.booking_id = 1""", nativeQuery = true)
    BookingSummaryProjection bookingInfo(Long id);
}
