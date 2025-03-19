package com.fitness_center.mapperTest;


import com.fitness_center.dto.EventDto;
import com.fitness_center.entities.Event;
import com.fitness_center.mapper.EventMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class EventMapperTest {

    private final EventMapper eventMapper = Mappers.getMapper(EventMapper.class);

    @Test
    void testToDto() {
        Event event = Event.builder()
                .id(1L)
                .title("Yoga Class")
                .description("Morning yoga session")
                .dateTime("2025-04-10 09:00")
                .location("Room A")
                .maxParticipants(15)

                .build();

        EventDto dto = eventMapper.toDto(event);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getTitle()).isEqualTo("Yoga Class");
        assertThat(dto.getDescription()).isEqualTo("Morning yoga session");
        assertThat(dto.getDateTime()).isEqualTo("2025-04-10 09:00");
        assertThat(dto.getLocation()).isEqualTo("Room A");
        assertThat(dto.getMaxParticipants()).isEqualTo(15);
    }

    @Test
    void testToEntity() {
        EventDto dto = new EventDto(1L, "Yoga Class", "Morning yoga session", "2025-04-10 09:00", "Room A", 15);

        Event event = eventMapper.toEntity(dto);

        assertThat(event).isNotNull();
        assertThat(event.getId()).isEqualTo(1L);
        assertThat(event.getTitle()).isEqualTo("Yoga Class");
        assertThat(event.getDescription()).isEqualTo("Morning yoga session");
        assertThat(event.getDateTime()).isEqualTo("2025-04-10 09:00");
        assertThat(event.getLocation()).isEqualTo("Room A");
        assertThat(event.getMaxParticipants()).isEqualTo(15);
    }
}
