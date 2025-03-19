package com.fitness_center.repositories;

import com.fitness_center.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();
}
