package com.fatin_noor.planmytrip.repository;

import com.fatin_noor.planmytrip.entity.Booking;
import com.fatin_noor.planmytrip.repository.projection.BookingSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(
        value = """
            select
                u.name as userName,
                t1.tour_package_name as tourPackageName,
                t.tour_category as category,
                t.package_price as packagePrice,
                t.allowed_person as allowedPerson,
                t1.description as description,
                t1.start_data as startDate
            FROM booking b
            left join tour_package_info t on b.tour_info_id = t.tour_category_id
            left join tour_packages t1 on t.tour_package_id = t1.id
            left join users u on b.user_id = u.user_id
            where b.booking_id = :id
            """,
        nativeQuery = true
    )
    BookingSummaryProjection bookingInfo(Long id);



    @Query(
            value = """
            select
                u.name as userName,
                t1.tour_package_name as tourPackageName,
                t.tour_category as category,
                t.package_price as packagePrice,
                t.allowed_person as allowedPerson,
                t1.description as description,
                t1.start_data as startDate
            FROM booking b
            left join tour_package_info t on b.tour_info_id = t.tour_category_id
            left join tour_packages t1 on t.tour_package_id = t1.id
            left join users u on b.user_id = u.user_id
            """,
            nativeQuery = true
    )
    List<BookingSummaryProjection> allBookingInfo();


    @Query(
        value = """
            select count(*) from booking b
            left join tour_package_info t on b.tour_info_id = t.tour_category_id
            left join users u on u.user_id = b.user_id
            where u.user_id = :userId and t.tour_category_id = :tourCategoryId
            """,
        nativeQuery = true
    )
    int countBookingByUserAndTourCategory(Long userId, Long tourCategoryId);

    @Query(
        value = """
            select t.tour_category, t2.tour_package_name, count(t.tour_category_id)
            from booking b
            inner join tour_package_info t on t.tour_category_id = b.tour_info_id
            left join tour_packages t2 on t2.id = t.tour_package_id
            group by t.tour_category, t2.tour_package_name
            """,
        nativeQuery = true
    )
    List<BookingSummaryProjection> getBookingSummary();
}