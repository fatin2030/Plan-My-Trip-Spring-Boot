package com.fatin_noor.planmytrip.tour_packege.controller;


import com.fatin_noor.planmytrip.tour_packege.dto.RegisterTourPackageDTO;
import com.fatin_noor.planmytrip.tour_packege.dto.TourPackageUpdateDTO;
import com.fatin_noor.planmytrip.tour_packege.repository.TourPackageRepository;
import com.fatin_noor.planmytrip.tour_packege.service.TourPackageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tour-packages")
public class TourPackageController {

    private final TourPackageService tourPackagesService;

    @PostMapping("/create")
    public ResponseEntity<Void> registerTourPackage(@Valid @RequestBody RegisterTourPackageDTO registerTourPackageDTO) {
        tourPackagesService.registerTourPackage(registerTourPackageDTO);
        return ResponseEntity.status(201).build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTourPackage(
            @PathVariable Long id,
            @RequestBody TourPackageUpdateDTO dto) {
        tourPackagesService.updateTourPackage(id, dto);
        return ResponseEntity.status(204).build();

    }


    @DeleteMapping("/delete-tour-package/{id}")

    public ResponseEntity<Void> deleteTourPackage(@PathVariable Long id) {
        tourPackagesService.deleteTourPackage(id);
        return ResponseEntity.status(204).build();

    }


    @GetMapping("/get-tour-packages/{name}")
    public List<RegisterTourPackageDTO> searchTourPackages(@PathVariable String name) {
        return this.tourPackagesService.searchTourPackage(name);
    }

    @GetMapping("/get-all-tour-packages")
    public List<RegisterTourPackageDTO> getAllTourPackages() {
        return this.tourPackagesService.getAllTourPackages();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<TourPackageRepository.TourPackageProjection> getTourPackageById(@PathVariable Long id) {
        return ResponseEntity.ok(tourPackagesService.getTourPackageById(id));
    }

    @GetMapping("/paginated-list")
    public ResponseEntity<Page<TourPackageRepository.TourPackageProjection>> getPaginatedTourPackages(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(tourPackagesService.getPaginatedTourPackages(page, size));
    }

}
