package com.sistemahorarios.service.mapper;

import com.sistemahorarios.api_dto.ClassDtos;
import com.sistemahorarios.domine.entities.Subject;

public class SubjectMapper {
    public static Subject toEntity(ClassDtos.ClassCreateRequest req){
        return Subject.builder().name(req.name()).description(req.description()).creditsNumber(req.creditsNumber()).build();
    }

    public static void patch(Subject c, ClassDtos.ClassUpdateRequest request){
        if (request.name() != null) {
            c.setName(request.name());
        }
        if (request.name() != null) {
            c.setDescription(request.description());
        }
        if (request.creditsNumber() != null){
            c.setCreditsNumber(request.creditsNumber());
        }
    }

    public static ClassDtos.ClassResponse toResponse(Subject c){
        return new ClassDtos.ClassResponse(c.getId(), c.getName(), c.getDescription(), c.getCreditsNumber());

    }
}
