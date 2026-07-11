package com.sistemahorarios.api_dto;

import java.io.Serializable;
import java.util.UUID;

public class ClassDtos {
    public record ClassCreateRequest(
            String name,
            String description,
            Integer creditsNumber
    ) implements Serializable {}

    public record ClassUpdateRequest(
            String name,
            String description,
            Integer creditsNumber
    ) implements Serializable{}

    public record ClassResponse(
            UUID id,
            String name,
            String description,
            Integer creditsNumber
    ) implements Serializable{}
}


