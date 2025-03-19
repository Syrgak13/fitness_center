package com.fitness_center.mapper;


import com.fitness_center.dto.TrainerDto;
import com.fitness_center.entities.Trainer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SectionMapper.class})
public interface TrainerMapper {
    TrainerDto toDto(Trainer trainer);
    Trainer toEntity(TrainerDto trainerDto);
}
