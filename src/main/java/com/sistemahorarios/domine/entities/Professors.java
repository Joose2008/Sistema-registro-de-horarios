package com.sistemahorarios.domine.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "professors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Professors {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

}
