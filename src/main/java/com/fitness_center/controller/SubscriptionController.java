package com.fitness_center.controller;

import com.fitness_center.dto.SubscriptionDto;
import com.fitness_center.service.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionServiceImpl service;

    @GetMapping
    public ResponseEntity<List<SubscriptionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<SubscriptionDto> create(@RequestBody SubscriptionDto dto) {
        return ResponseEntity.ok(service.addSubscription(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDto> update(@PathVariable Long id, @RequestBody SubscriptionDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.updateSubscription(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubscriptionDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteSubscription(id));
    }
}
