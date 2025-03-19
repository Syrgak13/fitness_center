package com.fitness_center.controller;

import com.fitness_center.dto.EventDto;
import com.fitness_center.service.EventService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor


public class EventController {
    private final EventService eventService;

    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public EventDto getEventById(Long id) {
    return eventService.getEventById(id);
    }

    @PostMapping
    public ResponseEntity <EventDto> addEvent(EventDto eventDto) {
        EventDto addedEvent = eventService.addEvent(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addedEvent);

    }

    @PutMapping("/{id}")
    public ResponseEntity <EventDto> updateEvent(@PathVariable Long id, EventDto eventDto) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
return ResponseEntity.ok("Event deleted successfully");
    }
}
