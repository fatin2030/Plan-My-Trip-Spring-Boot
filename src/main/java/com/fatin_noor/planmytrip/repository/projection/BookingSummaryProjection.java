package com.fatin_noor.planmytrip.repository.projection;


import java.time.LocalDate;

public interface BookingSummaryProjection {
    String getUserName();
    String getTourPackageName();
    String getCategory();
    Double getPackagePrice();
    Integer getAllowedPerson();
    String getDescription();
    LocalDate getStartDate();
}

