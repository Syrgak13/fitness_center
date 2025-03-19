package com.fitness_center.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class TrainerDto {

    private Long id;

    private String name;
    private String surname;
    private String phoneNumber;
    private String sectionCategory;
    private String gender;
}
