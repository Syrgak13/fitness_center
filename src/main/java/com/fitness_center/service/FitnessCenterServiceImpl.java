package com.fitness_center.service;

import com.fitness_center.dto.FitnessCenterDto;

import java.util.List;

public interface FitnessCenterServiceImpl {

    List<FitnessCenterDto> getAll ();

    FitnessCenterDto addFitnessCenter (FitnessCenterDto fitnessCenterDto);

    FitnessCenterDto updateFitnessCenter (FitnessCenterDto fitnessCenterDto);

    FitnessCenterDto deleteFitnessCenter (Long id);
}
