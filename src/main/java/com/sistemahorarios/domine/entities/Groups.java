package com.sistemahorarios.domine.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Groups {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @ManyToOne
        @JoinColumn(name = "id_classes", nullable = false)
        private Classes classes;

        @ManyToOne
        @JoinColumn(name = "id_professor", nullable = false)
        private Professors professor;

        @ManyToOne
        @JoinColumn(name = "id_schedule", nullable = false)
        private Schedules schedule;

        @Column(name="modality", nullable = false)
        private String modality;

}

