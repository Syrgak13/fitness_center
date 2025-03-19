package com.fitness_center.repositoryTest;


import com.fitness_center.entities.Event;
import com.fitness_center.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @BeforeEach
    void setUp() {
        // Очистка базы перед каждым тестом
        eventRepository.deleteAll();

        // Добавление тестовых событий
        Event event1 = Event.builder()
                .title("Yoga Class")
                .description("Morning yoga session")
                .dateTime("2025-03-20T10:00:00") // Строка вместо LocalDateTime
                .location("Room A")
                .maxParticipants(10)
                .build();

        Event event2 = Event.builder()
                .title("Strength Training")
                .description("Full body strength training")
                .dateTime("2025-03-21T15:00:00")
                .location("Gym Hall")
                .maxParticipants(15)
                .build();

        eventRepository.saveAll(List.of(event1, event2));
    }

    @Test
    @DisplayName("Тест метода findAll()")
    void testFindAll() {
        List<Event> events = eventRepository.findAll();

        // Проверяем, что найдено два события
        assertThat(events).hasSize(2);

        // Проверяем, что события содержат правильные заголовки
        assertThat(events).extracting(Event::getTitle)
                .containsExactlyInAnyOrder("Yoga Class", "Strength Training");

        // Проверяем даты (строковый формат)
        assertThat(events).extracting(Event::getDateTime)
                .containsExactlyInAnyOrder("2025-03-20T10:00:00", "2025-03-21T15:00:00");
    }
}
