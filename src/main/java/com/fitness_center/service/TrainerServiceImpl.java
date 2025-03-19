package com.fitness_center.service;

import com.fitness_center.dto.TrainerDto;

import java.util.List;

public interface TrainerServiceImpl {

    List <TrainerDto> getAll ();

    TrainerDto addTrainer (TrainerDto trainerDto);

    TrainerDto updateTrainer (TrainerDto trainerDto);

    TrainerDto deleteTrainer (Long id);

    TrainerDto getById (Long id);


}
