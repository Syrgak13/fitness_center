package com.fitness_center.controller;


import com.fitness_center.dto.FitnessCenterDto;
import com.fitness_center.service.FitnessCenterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fitness-centers")
@RequiredArgsConstructor
public class FitnessCenterController {

    private final FitnessCenterServiceImpl service;

    @GetMapping
    public ResponseEntity<List<FitnessCenterDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<FitnessCenterDto> addFitnessCenter(@RequestBody FitnessCenterDto dto) {
        return ResponseEntity.ok(service.addFitnessCenter(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessCenterDto> updateFitnessCenter(@PathVariable Long id, @RequestBody FitnessCenterDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.updateFitnessCenter(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FitnessCenterDto> deleteFitnessCenter (@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteFitnessCenter(id));
    }
}
