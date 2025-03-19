package com.fitness_center.repositories;

import com.fitness_center.entities.Subscription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository <Subscription, Long>{
    List<Subscription>findAll();
}
