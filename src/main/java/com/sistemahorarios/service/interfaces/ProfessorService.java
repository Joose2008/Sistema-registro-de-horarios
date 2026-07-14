package com.sistemahorarios.service.interfaces;

import com.sistemahorarios.api.dtos.ProfessorDtos.*;

import java.util.UUID;

public interface ProfessorService {
    ProfessorResponse create(ProfessorCreateRequest request);
    ProfessorResponse update(UUID id, ProfessorUpdateRequest request);
    void delete(UUID id);
    ProfessorResponse findById(UUID id);
}
