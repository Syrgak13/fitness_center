package com.fitness_center.mapper;


import com.fitness_center.dto.EventDto;
import com.fitness_center.entities.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto toDto(Event event);
    Event toEntity(EventDto eventDto);
}
