package com.sistemahorarios.service.mapper;

import com.sistemahorarios.api_dto.ClassDtos;
import com.sistemahorarios.domine.entities.Class;

public class ClassMapper {
    public static Class toEntity(ClassDtos.ClassCreateRequest req){
        return Class.builder().name(req.name()).description(req.description()).creditsNumber(req.creditsNumber()).build();
    }

    public static void patch(Class c, ClassDtos.ClassUpdateRequest request){
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

    public static ClassDtos.ClassResponse toResponse(Class c){
        return new ClassDtos.ClassResponse(c.getId(), c.getName(), c.getDescription(), c.getCreditsNumber());

    }
}
