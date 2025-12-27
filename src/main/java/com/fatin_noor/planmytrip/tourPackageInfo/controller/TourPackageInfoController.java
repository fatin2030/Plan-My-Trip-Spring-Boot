package com.fatin_noor.planmytrip.tourPackageInfo.controller;

import com.fatin_noor.planmytrip.tourPackageInfo.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourPackageInfo.service.TourPackageInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tour-package-info")
@RequiredArgsConstructor
public class TourPackageInfoController {

    private final TourPackageInfoService tourPackageInfoService;

    @PostMapping("/add-package-info/{id}/add-info")

    public ResponseEntity<Void> addTourPackageInfo(@PathVariable Long id, @RequestBody AddTourPackageInfoDTO tourPackageInfoDTO) {
        tourPackageInfoService.addTourPackageInfo(id, tourPackageInfoDTO);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/api/tour-package-info/{id}")
    public ResponseEntity<Void> updateTourPackageInfo(@PathVariable Long id, @Valid @RequestBody TourPackageInfoDTO tourPackageInfoDTO) {
        tourPackageInfoService.updateTourPackageInfo(id, tourPackageInfoDTO);
        return ResponseEntity.status(204).build();
    }


}
