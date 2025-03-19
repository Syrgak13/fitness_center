package com.fitness_center.repositories;

import com.fitness_center.entities.FitnessCenter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FitnessCenterRepository extends CrudRepository <FitnessCenter, Long> {
    List<FitnessCenter> findAll();

}
