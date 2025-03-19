package com.fitness_center.service;


import com.fitness_center.dto.FitnessCenterDto;
import com.fitness_center.entities.FitnessCenter;
import com.fitness_center.mapper.FitnessCenterMapper;
import com.fitness_center.repositories.FitnessCenterRepository;
import com.fitness_center.service.FitnessCenterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FitnessCenterService implements FitnessCenterServiceImpl {

    private final FitnessCenterRepository repository;
    private final FitnessCenterMapper mapper;

    @Override
    public List<FitnessCenterDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FitnessCenterDto addFitnessCenter(FitnessCenterDto dto) {
        FitnessCenter entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public FitnessCenterDto updateFitnessCenter(FitnessCenterDto dto) {
        FitnessCenter fitnessCenter = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Fitness Center not found"));

        fitnessCenter.setName(dto.getName());
        fitnessCenter.setLocation(dto.getLocation());
        fitnessCenter.setPhone(dto.getPhone());
        fitnessCenter.setEmail(dto.getEmail());
        fitnessCenter.setRating(dto.getRating());

        return mapper.toDto(repository.save(fitnessCenter));
    }

    @Override
    public FitnessCenterDto deleteFitnessCenter(Long id) {
        FitnessCenter fitnessCenter = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fitness Center not found"));
        repository.delete(fitnessCenter);
        return mapper.toDto(fitnessCenter);
    }
}
