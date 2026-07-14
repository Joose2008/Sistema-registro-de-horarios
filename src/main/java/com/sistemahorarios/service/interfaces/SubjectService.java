package com.sistemahorarios.service.interfaces;

import com.sistemahorarios.api.dtos.SubjectDtos.*;

import java.util.UUID;

public interface SubjectService {
    SubjectResponse create(SubjectCreateRequest request);
    SubjectResponse findById(UUID id);
    void delete(UUID id);
    SubjectResponse update(UUID id, SubjectUpdateRequest request);


}
