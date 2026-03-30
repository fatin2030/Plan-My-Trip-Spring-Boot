package com.fatin_noor.planmytrip.company.service;

import com.fatin_noor.planmytrip.company.dto.CompanyCreateDto;
import com.fatin_noor.planmytrip.company.repository.CompanyRepository;
import com.fatin_noor.planmytrip.enums.Status;
import org.springframework.data.domain.Page;

public interface CompanyService {

    void createCompany(CompanyCreateDto companyCreateDto);

    void verifyCompany(Long companyId, Status status);

    Page<CompanyRepository.CompanyDetailsProjection> getAllCompanyPaginatedList(int page, int size);

    CompanyRepository.CompanyDetailsProjection getCompanyDetailsById(Long companyId);
}
