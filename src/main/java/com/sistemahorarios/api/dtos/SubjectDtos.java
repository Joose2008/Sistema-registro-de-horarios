package com.sistemahorarios.api.dtos;

import java.io.Serializable;
import java.util.UUID;

public class SubjectDtos {
    public record SubjectCreateRequest(
            String name,
            String description,
            Integer creditsNumber
    ) implements Serializable {}

    public record SubjectUpdateRequest(
            String name,
            String description,
            Integer creditsNumber
    ) implements Serializable{}

    public record SubjectResponse(
            UUID id,
            String name,
            String description,
            Integer creditsNumber
    ) implements Serializable{}
}


