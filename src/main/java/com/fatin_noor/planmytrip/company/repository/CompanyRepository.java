package com.fatin_noor.planmytrip.company.repository;

import com.fatin_noor.planmytrip.company.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    String FIND_ALL_COMPANY_DETAILS = """
                              SELECT
                                c.id AS companyId,
                                c.company_name AS companyName,
                                c.email AS companyEmail,
                                c.phone_number AS companyPhoneNumber,
                                c.status AS companyStatus,
                                a.country AS country,
                                a.city AS city,
                                a.street AS street,
                                a.postal_code AS postalCode,
                                a.house_no AS houseNo,
                                a.description AS addressDescription
                              FROM
                                company c
                              LEFT JOIN
                                address a ON c.address_id = a.id
                              WHERE c.deleted = false
            """;

    String COUNT_QUERY = """
                              SELECT
                                COUNT(c.id)
                              FROM
                                company c
                              LEFT JOIN
                                address a ON c.address_id = a.id
                              WHERE c.deleted = false
            """;
    @Query(value = FIND_ALL_COMPANY_DETAILS, countQuery = COUNT_QUERY, nativeQuery = true)
    Page<CompanyDetailsProjection> findAllCompanyDetails(Pageable pageable);

    @Query(value = """
                 SELECT
                    c.id AS companyId,
                    c.company_name AS companyName,
                    c.email AS companyEmail,
                    c.phone_number AS companyPhoneNumber,
                    c.status AS companyStatus,
                    a.country AS country,
                    a.city AS city,
                    a.street AS street,
                    a.postal_code AS postalCode,
                    a.house_no AS houseNo,
                    a.description AS addressDescription
                  FROM
                    company c
                  LEFT JOIN
                    address a ON c.address_id = a.id
                  WHERE c.deleted = false AND c.id = :companyId
            """, nativeQuery = true)
    CompanyDetailsProjection findCompanyDetailsById(Long companyId);


    interface CompanyDetailsProjection {
        Long getCompanyId();
        String getCompanyName();
        String getCompanyEmail();
        String getCompanyPhoneNumber();
        String getCompanyStatus();
        String getCountry();
        String getCity();
        String getStreet();
        String getPostalCode();
        String getHouseNo();
        String getAddressDescription();
    }
}
