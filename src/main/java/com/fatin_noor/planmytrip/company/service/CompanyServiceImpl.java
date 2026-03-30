package com.fatin_noor.planmytrip.company.service;

import com.fatin_noor.planmytrip.company.dto.CompanyCreateDto;
import com.fatin_noor.planmytrip.company.entity.Company;
import com.fatin_noor.planmytrip.company.repository.CompanyRepository;
import com.fatin_noor.planmytrip.enums.Status;
import com.fatin_noor.planmytrip.user.entity.Address;
import com.fatin_noor.planmytrip.user.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.fatin_noor.planmytrip.enums.Status.PENDING;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public void createCompany(CompanyCreateDto companyCreateDto) {
        Company company = new Company();
        Address address = new Address();

        BeanUtils.copyProperties(companyCreateDto,company);
        BeanUtils.copyProperties(companyCreateDto.getAddress(),address);
        addressRepository.save(address);
        company.setAddress(address);
        company.setStatus(PENDING);
        companyRepository.save(company);

    }

    @Transactional
    @Override
    public void verifyCompany(Long companyId, Status status) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));

        company.setStatus(status);


    }

    @Override
    public Page<CompanyRepository.CompanyDetailsProjection> getAllCompanyPaginatedList(int page, int size) {
        return companyRepository.findAllCompanyDetails(PageRequest.of(page,size));
    }

    @Override
    public CompanyRepository.CompanyDetailsProjection getCompanyDetailsById(Long companyId) {
        return null;
    }
}
