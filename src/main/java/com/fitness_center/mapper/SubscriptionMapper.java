package com.fitness_center.mapper;


import com.fitness_center.dto.SubscriptionDto;
import com.fitness_center.entities.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionDto toDto(Subscription subscription);
    Subscription toEntity(SubscriptionDto subscriptionDto);
}
