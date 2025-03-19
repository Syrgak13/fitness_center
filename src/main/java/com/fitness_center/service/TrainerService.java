package com.fitness_center.service;

import com.fitness_center.dto.TrainerDto;
import com.fitness_center.entities.Trainer;
import com.fitness_center.mapper.TrainerMapper;
import com.fitness_center.repositories.TrainerRepository;
import com.fitness_center.service.TrainerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainerService implements TrainerServiceImpl {

    private final TrainerRepository repository;
    private final TrainerMapper mapper;

    @Override
    public List<TrainerDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TrainerDto getById(Long id) {
        Trainer trainer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        return mapper.toDto(trainer);
    }

    @Override
    public TrainerDto addTrainer(TrainerDto dto) {
        Trainer entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public TrainerDto updateTrainer(TrainerDto dto) {
        Trainer trainer = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        trainer.setName(dto.getName());
        trainer.setSurname(dto.getSurname());
        trainer.setPhoneNumber(dto.getPhoneNumber());
        trainer.setSectionCategory(dto.getSectionCategory());
        trainer.setGender(dto.getGender());

        return mapper.toDto(repository.save(trainer));
    }

    @Override
    public TrainerDto deleteTrainer(Long id) {
        Trainer trainer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        repository.delete(trainer);
        return mapper.toDto(trainer);
    }
}
