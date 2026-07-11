package com.sistemahorarios.api_dto;

import com.sistemahorarios.domine.enums.Modality;

import java.io.Serializable;
import java.util.UUID;

public class GroupDtos {
    public record GroupCreateRequest(
            UUID classesId,
            UUID professorId,
            UUID scheduleId,
            Modality modality
    ) implements Serializable {}

    public record GroupUpdateRequest(
            UUID classesId,
            UUID professorId,
            UUID scheduleId,
            Modality modality
    ) implements Serializable {}

    public record GroupResponse(
            UUID id,
            UUID classesId,
            UUID professorId,
            UUID scheduleId,
            Modality modality
    ) implements Serializable {}
}
