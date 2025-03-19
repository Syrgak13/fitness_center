package com.fitness_center.repositoryTest;


import com.fitness_center.entities.Section;
import com.fitness_center.repositories.SectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SectionRepositoryTest {

    @Autowired
    private SectionRepository sectionRepository;

    @BeforeEach
    void setUp() {

        sectionRepository.deleteAll();


        Section section1 = Section.builder()
                .name("Yoga")
                .description("Relaxing and stretching exercises")
                .build();

        Section section2 = Section.builder()
                .name("Cardio")
                .description("High-intensity training for endurance")
                .build();

        sectionRepository.saveAll(List.of(section1, section2));
    }

    @Test
    @DisplayName("Тест метода findAll()")
    void testFindAll() {
        List<Section> sections = sectionRepository.findAll();

        // Проверяем, что найдено две секции
        assertThat(sections).hasSize(2);

        // Проверяем, что секции содержат правильные названия
        assertThat(sections).extracting(Section::getName)
                .containsExactlyInAnyOrder("Yoga", "Cardio");

        // Проверяем описания секций
        assertThat(sections).extracting(Section::getDescription)
                .containsExactlyInAnyOrder(
                        "Relaxing and stretching exercises",
                        "High-intensity training for endurance"
                );
    }
}
