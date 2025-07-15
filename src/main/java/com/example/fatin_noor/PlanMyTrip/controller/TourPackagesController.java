package com.example.fatin_noor.PlanMyTrip.controller;


import com.example.fatin_noor.PlanMyTrip.dto.AddTourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.RegisterTourPackageDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageInfoDTO;
import com.example.fatin_noor.PlanMyTrip.dto.TourPackageUpdateDTO;
import com.example.fatin_noor.PlanMyTrip.serviceImpl.TourPackageServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TourPackagesController {

    private final TourPackageServiceImpl tourPackagesService;

    @PostMapping("api/addPackages")
    public RegisterTourPackageDTO registerTourPackage(@Valid @RequestBody RegisterTourPackageDTO registerTourPackageDTO){
        return this.tourPackagesService.registerTourPackage(registerTourPackageDTO);
    }

    @PostMapping("api/add-package-info/{id}/add-info")

    public List<TourPackageInfoDTO> addTourPackageInfo(@PathVariable Long id, @RequestBody AddTourPackageInfoDTO tourPackageInfoDTO){
        return this.tourPackagesService.addTourPackageInfo(id,tourPackageInfoDTO);
    }

    @PatchMapping("/api/tour-packages/{id}")
    public TourPackageUpdateDTO updateTourPackage(
            @PathVariable Long id,
            @RequestBody TourPackageUpdateDTO dto) {
        return this.tourPackagesService.updateTourPackage(id, dto);
    }

    @PutMapping ("/api/tour-package-info/{id}")
    public TourPackageInfoDTO updateTourPackageInfo(@PathVariable Long id ,@Valid @RequestBody TourPackageInfoDTO tourPackageInfoDTO){
        return  this.tourPackagesService.updateTourPackageInfo(id,tourPackageInfoDTO);
    }

    @DeleteMapping("/api/delete-tour-package/{id}")

    public String deleteTourPackage(@PathVariable Long id){
        return this.tourPackagesService.deleteTourPackage(id);

    }


    @GetMapping("/api/get-tour-packages/{name}")
    public List<RegisterTourPackageDTO> searchTourPackages(@PathVariable String name){
        return this.tourPackagesService.searchTourPackage(name);
    }

}
