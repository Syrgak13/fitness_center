package com.fitness_center.service;

import com.fitness_center.dto.EventDto;
import com.fitness_center.entities.Event;
import com.fitness_center.mapper.EventMapper;
import com.fitness_center.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class EventService implements EventServiceImpl {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;



    @Override
    public List<EventDto> getAll() {
        return eventRepository
                .findAll()
        .stream()
                .map(eventMapper::toDto)
        .collect(Collectors.toList());
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        return eventMapper.toDto(event);
    }

    @Override
    public EventDto addEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        Event saveEvent = eventRepository.save(event);
        return eventMapper.toDto(saveEvent);

    }

    @Override
    public EventDto updateEvent(EventDto eventDto) {
        Event existingEvent = eventRepository.findById(eventDto.getId()).orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setTitle(eventDto.getTitle());
        Event updatedEvent = eventRepository.save(existingEvent);
        return eventMapper.toDto(updatedEvent);

    }

    @Override
    public EventDto deleteEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepository.delete(event);
        return eventMapper.toDto(event);
    }
}
