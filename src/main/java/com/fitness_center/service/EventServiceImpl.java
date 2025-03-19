package com.fitness_center.service;

import com.fitness_center.dto.EventDto;

import java.util.List;

public interface EventServiceImpl {

    List<EventDto> getAll ();

    EventDto getEventById (Long id);

    EventDto addEvent (EventDto eventDto);

    EventDto updateEvent (EventDto eventDto);

    EventDto updateEvent(Long id, EventDto eventDto);

    EventDto deleteEvent (Long id);
}
