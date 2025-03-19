package com.fitness_center.entities;

import jakarta.persistence.*;
        import lombok.*;

import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FitnessCenter {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;
    private String phone;
    private String email;
    private String rating;

    @OneToOne
    private Event event;

    @OneToMany
    private List<Section> sectionList;

    @OneToMany
    private List<Trainer> trainerList;

    @OneToMany
    private List<Subscription> subscriptiontList;


}
