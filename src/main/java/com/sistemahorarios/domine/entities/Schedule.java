package com.sistemahorarios.domine.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "schedules")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name="day_of_week", nullable = false)
    private DayOfWeek day_of_week;

    @Column(name="start", nullable = false)
    private LocalTime start;

    @Column(name="end", nullable = false)
    private LocalTime end;
}
