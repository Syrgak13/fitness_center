package com.fitness_center.repositoryTest;


import com.fitness_center.entities.*;
import com.fitness_center.repositories.EventRepository;
import com.fitness_center.repositories.FitnessCenterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FitnessCenterRepositoryTest {

    @Autowired
    private FitnessCenterRepository fitnessCenterRepository;

    @Autowired
    private EventRepository eventRepository;

    @BeforeEach
    void setUp() {
        // Очистка базы перед каждым тестом
        fitnessCenterRepository.deleteAll();
        eventRepository.deleteAll();

        // Создаем тестовое событие
        Event event = Event.builder()
                .title("Yoga Session")
                .description("Morning yoga session")
                .dateTime("2025-03-20T10:00:00")
                .location("Main Hall")
                .maxParticipants(15)
                .build();

        eventRepository.save(event);

        // Создаем фитнес-центр
        FitnessCenter center = FitnessCenter.builder()
                .name("FitLife Gym")
                .location("Downtown")
                .phone("123-456-7890")
                .email("info@fitlife.com")
                .rating("4.8")
                .event(event)  // Связь с событием
                .build();

        fitnessCenterRepository.save(center);
    }

    @Test
    @DisplayName("Тест метода findAll()")
    void testFindAll() {
        List<FitnessCenter> centers = fitnessCenterRepository.findAll();

        // Проверяем, что найден один фитнес-центр
        assertThat(centers).hasSize(1);

        // Проверяем его название
        assertThat(centers.get(0).getName()).isEqualTo("FitLife Gym");

        // Проверяем связь с событием
        assertThat(centers.get(0).getEvent()).isNotNull();
        assertThat(centers.get(0).getEvent().getTitle()).isEqualTo("Yoga Session");
    }
}
