package com.fitness_center.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class FitnessCenterDto {
    private Long id;

    private String name;
    private String location;
    private String phone;
    private String email;
    private String rating;


}
