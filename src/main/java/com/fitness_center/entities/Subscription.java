package com.fitness_center.entities;



import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Месячный, годовой
    private double price;
    private LocalDate startDate;
    private LocalDate endDate;
}
