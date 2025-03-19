package com.fitness_center.mapper;


import com.fitness_center.dto.SectionDto;
import com.fitness_center.entities.Section;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    SectionDto toDto(Section section);
    Section toEntity(SectionDto sectionDto);
}

