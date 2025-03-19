package com.fitness_center.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class SubscriptionDto {

    private Long id;

    private String type; // Месячный, годовой
    private double price;
    private String startDate;
    private String endDate;
}
