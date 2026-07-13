package com.sistemahorarios.api.dtos;

import java.io.Serializable;
import java.util.UUID;

public class ProfessorDtos {
    public record ProfessorCreateRequest(
            String name
    ) implements Serializable {}

    public record ProfessorUpdateRequest(
            String name
    ) implements Serializable {}

    public record ProfessorResponse(
            UUID id,
            String name
    ) implements Serializable {}
}
