package com.fatin_noor.planmytrip.company.controller;

import com.fatin_noor.planmytrip.company.dto.CompanyCreateDto;
import com.fatin_noor.planmytrip.company.repository.CompanyRepository;
import com.fatin_noor.planmytrip.company.service.CompanyService;
import com.fatin_noor.planmytrip.enums.Status;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Void> createCompany(@Valid @RequestBody CompanyCreateDto companyCreateDto) {
        companyService.createCompany(companyCreateDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("verify/{id}")
    public ResponseEntity<Void> verifyCompany(@PathVariable Long id, @RequestParam Status status) {
        companyService.verifyCompany(id, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<CompanyRepository.CompanyDetailsProjection>> getAllCompanyPaginatedList(@RequestParam(defaultValue = "0") int page,
                                                                                                       @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(companyService.getAllCompanyPaginatedList(page, size));
    }
}
