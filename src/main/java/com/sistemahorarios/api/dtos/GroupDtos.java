package com.sistemahorarios.api.dtos;

import com.sistemahorarios.domine.enums.Modality;

import java.io.Serializable;
import java.util.UUID;

public class GroupDtos {
    public record GroupCreateRequest(
            UUID subjectId,
            UUID professorId,
            UUID scheduleId,
            Modality modality
    ) implements Serializable {}

    public record GroupUpdateRequest(
            UUID subjectId,
            UUID professorId,
            UUID scheduleId,
            Modality modality
    ) implements Serializable {}

    public record GroupResponse(
            UUID id,
            UUID subjectId,
            UUID professorId,
            UUID scheduleId,
            Modality modality
    ) implements Serializable {}
}
