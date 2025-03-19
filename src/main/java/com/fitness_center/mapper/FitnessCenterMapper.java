package com.fitness_center.mapper;


import com.fitness_center.dto.FitnessCenterDto;
import com.fitness_center.entities.FitnessCenter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FitnessCenterMapper {
    FitnessCenterDto toDto(FitnessCenter fitnessCenter);
    FitnessCenter toEntity(FitnessCenterDto fitnessCenterDto);
}
