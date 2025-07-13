package com.example.fatin_noor.PlanMyTrip.controller;

import com.example.fatin_noor.PlanMyTrip.dto.AddTourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.RegisterTourPackageDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.serviceImpl.TourPackageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TourPackageController {
    private final TourPackageServiceImpl tourPackagesService;

    @PostMapping("api/addPackages")
    public RegisterTourPackageDTO registerTourPackage(@RequestBody RegisterTourPackageDTO registerTourPackageDTO) {
        return this.tourPackagesService.registerTourPackage(registerTourPackageDTO);
    }

    @PostMapping("api/add-package-info/{id}/add-info")

    public List<TourPackageInfoDTO> addTourPackageInfo(@PathVariable Long id, @RequestBody AddTourPackageInfoDTO tourPackageInfoDTO) {
        return this.tourPackagesService.addTourPackageInfo(id, tourPackageInfoDTO);
    }
}
