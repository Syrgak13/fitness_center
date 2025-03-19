package com.fitness_center.repositoryTest;


import com.fitness_center.entities.Trainer;
import com.fitness_center.repositories.TrainerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TrainerRepositoryTest {

    @Autowired
    private TrainerRepository trainerRepository;

    @BeforeEach
    void setUp() {
        // Очистка базы перед каждым тестом
        trainerRepository.deleteAll();

        // Создаем тестовых тренеров
        Trainer trainer1 = Trainer.builder()
                .name("John")
                .surname("Doe")
                .phoneNumber("+123456789")
                .sectionCategory("Yoga")
                .gender("Male")
                .build();

        Trainer trainer2 = Trainer.builder()
                .name("Anna")
                .surname("Smith")
                .phoneNumber("+987654321")
                .sectionCategory("Cardio")
                .gender("Female")
                .build();

        trainerRepository.saveAll(List.of(trainer1, trainer2));
    }

    @Test
    @DisplayName("Тест метода findAll()")
    void testFindAll() {
        List<Trainer> trainers = trainerRepository.findAll();

        // Проверяем, что найдено два тренера
        assertThat(trainers).hasSize(2);

        // Проверяем, что тренеры содержат правильные имена
        assertThat(trainers).extracting(Trainer::getName)
                .containsExactlyInAnyOrder("John", "Anna");

        // Проверяем категории секций
        assertThat(trainers).extracting(Trainer::getSectionCategory)
                .containsExactlyInAnyOrder("Yoga", "Cardio");

        // Проверяем гендер
        assertThat(trainers).extracting(Trainer::getGender)
                .containsExactlyInAnyOrder("Male", "Female");
    }
}
