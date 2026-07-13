package com.sistemahorarios.service.mapper;

import com.sistemahorarios.domine.entities.Subject;

public class SubjectMapper {
    public static Subject toEntity(com.sistemahorarios.api_dto.SubjectDtos.ClassCreateRequest req){
        return Subject.builder().name(req.name()).description(req.description()).creditsNumber(req.creditsNumber()).build();
    }

    public static void patch(Subject c, com.sistemahorarios.api_dto.SubjectDtos.ClassUpdateRequest request){
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

    public static com.sistemahorarios.api_dto.SubjectDtos.ClassResponse toResponse(Subject c){
        return new com.sistemahorarios.api_dto.SubjectDtos.ClassResponse(c.getId(), c.getName(), c.getDescription(), c.getCreditsNumber());

    }
}
