package com.fatin_noor.planmytrip.tour_package_category.controller;

import com.fatin_noor.planmytrip.tour_package_category.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_category.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tour_package_category.service.TourPackageCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tour-package-info")
@RequiredArgsConstructor
public class TourPackageInfoController {

    private final TourPackageCategoryService tourPackageCategoryService;

    @PostMapping("/create")
    public ResponseEntity<Void> addTourPackageInfo( @RequestBody AddTourPackageInfoDTO tourPackageInfoDTO) {
        tourPackageCategoryService.addTourPackageInfo(tourPackageInfoDTO);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/api/tour-package-info/{id}")
    public ResponseEntity<Void> updateTourPackageInfo(@PathVariable Long id, @Valid @RequestBody TourPackageInfoDTO tourPackageInfoDTO) {
        tourPackageCategoryService.updateTourPackageInfo(id, tourPackageInfoDTO);
        return ResponseEntity.status(204).build();
    }


}
