package com.sistemahorarios.service.mapper;

import com.sistemahorarios.domine.entities.Subject;

public class SubjectMapper {
    public static Subject toEntity(com.sistemahorarios.api.dtos.SubjectDtos.SubjectCreateRequest req){
        return Subject.builder().name(req.name()).description(req.description()).creditsNumber(req.creditsNumber()).build();
    }

    public static void patch(Subject c, com.sistemahorarios.api.dtos.SubjectDtos.SubjectUpdateRequest request){
        if (request.name() != null) {
            c.setName(request.name());
        }
        if (request.description() != null) {
            c.setDescription(request.description());
        }
        if (request.creditsNumber() != null){
            c.setCreditsNumber(request.creditsNumber());
        }
    }

    public static com.sistemahorarios.api.dtos.SubjectDtos.SubjectResponse toResponse(Subject c){
        return new com.sistemahorarios.api.dtos.SubjectDtos.SubjectResponse(c.getId(), c.getName(), c.getDescription(), c.getCreditsNumber());

    }
}
