package com.fitness_center.controller;

import com.fitness_center.dto.TrainerDto;
import com.fitness_center.service.TrainerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerServiceImpl service;

    @GetMapping
    public ResponseEntity<List<TrainerDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<TrainerDto> create(@RequestBody TrainerDto dto) {
        return ResponseEntity.ok(service.addTrainer(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainerDto> update(@PathVariable Long id, @RequestBody TrainerDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.updateTrainer(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrainerDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteTrainer(id));
    }
}
