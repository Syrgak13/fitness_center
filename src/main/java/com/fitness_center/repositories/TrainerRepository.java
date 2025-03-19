package com.fitness_center.repositories;

import com.fitness_center.entities.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainerRepository extends CrudRepository <Trainer, Long> {
    List <Trainer> findAll();
}
