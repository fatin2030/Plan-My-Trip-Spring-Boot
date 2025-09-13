package com.fatin_noor.planmytrip.tourpackege.controller;


import com.fatin_noor.planmytrip.tourpackege.dto.AddTourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.TourPackageInfoDTO;
import com.fatin_noor.planmytrip.tourpackege.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.tourpackege.service.TourPackageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TourPackagesController {

    private final TourPackageService tourPackagesService;

    @PostMapping("api/addPackages")
    public ResponseEntity<Void> registerTourPackage(@Valid @RequestBody RegisterTourPackageDTO registerTourPackageDTO){
        tourPackagesService.registerTourPackage(registerTourPackageDTO);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("api/add-package-info/{id}/add-info")

    public ResponseEntity<Void> addTourPackageInfo(@PathVariable Long id, @RequestBody AddTourPackageInfoDTO tourPackageInfoDTO){
        tourPackagesService.addTourPackageInfo(id,tourPackageInfoDTO);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/api/tour-packages/{id}")
    public ResponseEntity<Void> updateTourPackage(
            @PathVariable Long id,
            @RequestBody TourPackageUpdateDTO dto) {
        tourPackagesService.updateTourPackage(id, dto);
        return ResponseEntity.status(204).build();

    }

    @PutMapping ("/api/tour-package-info/{id}")
    public ResponseEntity<Void> updateTourPackageInfo(@PathVariable Long id ,@Valid @RequestBody TourPackageInfoDTO tourPackageInfoDTO){
      tourPackagesService.updateTourPackageInfo(id,tourPackageInfoDTO);
      return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/api/delete-tour-package/{id}")

    public ResponseEntity<Void> deleteTourPackage(@PathVariable Long id){
        tourPackagesService.deleteTourPackage(id);
        return ResponseEntity.status(204).build();

    }


    @GetMapping("/api/get-tour-packages/{name}")
    public List<RegisterTourPackageDTO> searchTourPackages(@PathVariable String name){
        return this.tourPackagesService.searchTourPackage(name);
    }

    @GetMapping("/api/get-all-tour-packages")
    public List<RegisterTourPackageDTO> getAllTourPackages() {
        return this.tourPackagesService.getAllTourPackages();
    }

}
