package com.sistemahorarios.domine.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "classes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name="credits_number", nullable = false)
    private Integer creditsNumber;
}
