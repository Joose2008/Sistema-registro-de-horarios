package com.sistemahorarios.domine.entities;

import com.sistemahorarios.domine.enums.Modality;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @ManyToOne
        @JoinColumn(name = "id_classes", nullable = false)
        private Class classes;

        @ManyToOne
        @JoinColumn(name = "id_professor", nullable = false)
        private Professor professor;

        @ManyToOne
        @JoinColumn(name = "id_schedule", nullable = false)
        private Schedule schedule;

        @Column(name="modality", nullable = false)
        private Modality modality;
}

