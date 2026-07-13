package com.sistemahorarios.service.mapper;

import com.sistemahorarios.api.dtos.ProfessorDtos.*;
import com.sistemahorarios.domine.entities.Professor;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorCreateRequest request) {
        return Professor.builder()
                .name(request.name())
                .build();
    }

    public static void updateEntity(Professor p, ProfessorUpdateRequest request) {
        p.setName(request.name());
    }

    public static ProfessorResponse toResponse(Professor p) {
        return new ProfessorResponse(
                p.getId(),
                p.getName()
        );
    }
}