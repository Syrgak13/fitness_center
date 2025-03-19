package com.fitness_center.service;


import com.fitness_center.dto.SectionDto;
import com.fitness_center.entities.Section;
import com.fitness_center.mapper.SectionMapper;
import com.fitness_center.repositories.SectionRepository;
import com.fitness_center.service.SectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionService implements SectionServiceImpl {

    private final SectionRepository repository;
    private final SectionMapper mapper;

    @Override
    public List<SectionDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SectionDto getSectionById(Long id) {
        Section section = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));
        return mapper.toDto(section);
    }

    @Override
    public SectionDto addSection(SectionDto dto) {
        Section entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public SectionDto updateSection(SectionDto dto) {
        Section section = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Section not found"));

        section.setName(dto.getName());
        section.setDescription(dto.getDescription());

        return mapper.toDto(repository.save(section));
    }

    @Override
    public SectionDto deleteSection(Long id) {
        Section section = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));
        repository.delete(section);
        return mapper.toDto(section);
    }
}
