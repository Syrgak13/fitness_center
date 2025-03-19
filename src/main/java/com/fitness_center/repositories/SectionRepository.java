package com.fitness_center.repositories;

import com.fitness_center.entities.Section;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectionRepository extends CrudRepository <Section, Long> {
    List<Section> findAll();

}
