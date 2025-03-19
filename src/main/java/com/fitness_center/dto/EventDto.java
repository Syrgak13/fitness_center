package com.fitness_center.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class EventDto {

    private Long id;

    private String title;
    private String description;
    private String dateTime;
    private String location;
    private int maxParticipants;


}
