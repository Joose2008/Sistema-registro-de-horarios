package com.sistemahorarios.service.interfaces;

import com.sistemahorarios.api.dtos.GroupDtos.*;
import com.sistemahorarios.domine.enums.Modality;

import java.util.List;
import java.util.UUID;

public interface GroupService {
    GroupResponse create(GroupCreateRequest request);
    GroupResponse update(UUID id, GroupUpdateRequest request);
    void delete(UUID id);
    GroupResponse findById(UUID id);
    List<GroupResponse> findAll();
    List<GroupResponse> findBySubject(UUID subjectId);
    List<GroupResponse> findByProfessor(UUID professorId);
    List<GroupResponse> findBySchedule(UUID scheduleId);
    List<GroupResponse> findByModality(Modality modality);
}
