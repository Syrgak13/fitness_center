package com.fitness_center.controller;

import com.fitness_center.dto.SectionDto;
import com.fitness_center.service.SectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionServiceImpl service;

    @GetMapping
    public ResponseEntity<List<SectionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionDto> getSectionById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSectionById(id));
    }

    @PostMapping
    public ResponseEntity<SectionDto> addSection(@RequestBody SectionDto dto) {
        return ResponseEntity.ok(service.addSection(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectionDto> updateSection(@PathVariable Long id, @RequestBody SectionDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.updateSection(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SectionDto> deleteSection(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteSection(id));
    }
}
