package com.fitness_center.entities;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String dateTime;
    private String location;
    private int maxParticipants;


}

