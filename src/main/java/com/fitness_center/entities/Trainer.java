package com.fitness_center.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Trainer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private String phoneNumber;
    private String sectionCategory;
    private String gender;


}
