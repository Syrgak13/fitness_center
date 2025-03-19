package com.fitness_center.bootstrap;

import com.fitness_center.entities.Event;
import com.fitness_center.entities.Section;
import com.fitness_center.entities.Subscription;
import com.fitness_center.entities.Trainer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class DataInit {
    @PostConstruct
    public void initData() {
        Trainer dastan = Trainer.builder()
                .name("Dastan")
                .surname("Kurbanov")
                .gender("male")
                .phoneNumber("501061009")
                .sectionCategory("bodybuilding")
                .build();

        Trainer salima = Trainer.builder()
                .name("Salima")
                .surname("Tabyldieva")
                .gender("female")
                .sectionCategory("yoga")
                .build();

        Subscription vip = Subscription.builder()
                .type("unlimited")
                .price(1000.0)
                .startDate("2023-01-01")
                .endDate("2023-12-31")
                .build();

        Subscription basic = Subscription.builder()
                .type("limited")
                .price(500.0)
                .startDate("2023-01-01")
                .endDate("2023-12-31")
                .build();

        Section bodybuilding = Section.builder()
                .name("Bodybuilding")
                .description("Bodybuilding is a sport that involves strength training and body shaping.")
                .build();

        Section yoga = Section.builder()
                .name("Yoga")
                .description("Yoga is a physical, mental, and spiritual practice or discipline that originated in ancient India.")
                .build();

        Event promotion = Event.builder()
                .title("New Year Promotion")
                .description("Get 20% off on all subscriptions for the first month.")
                .dateTime("2023-01-01T00:00:00")
                .location("Fitness Center")
                .maxParticipants(100)
                .build();

        Event workshop = Event.builder()
                .title("Yoga Workshop")
                .description("Join us for a free yoga workshop on January 15th.")
                .dateTime("2023-01-15T10:00:00")
                .location("Fitness Center")
                .maxParticipants(50)
                .build();

    }
}
