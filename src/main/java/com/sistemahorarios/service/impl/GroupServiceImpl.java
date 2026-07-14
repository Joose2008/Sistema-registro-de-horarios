package com.sistemahorarios.service.impl;

import com.sistemahorarios.api.dtos.GroupDtos.*;
import com.sistemahorarios.domine.entities.Group;
import com.sistemahorarios.domine.entities.Professor;
import com.sistemahorarios.domine.entities.Schedule;
import com.sistemahorarios.domine.entities.Subject;
import com.sistemahorarios.domine.enums.Modality;
import com.sistemahorarios.domine.repositories.GroupRepository;
import com.sistemahorarios.domine.repositories.ProfessorRepository;
import com.sistemahorarios.domine.repositories.ScheduleRepository;
import com.sistemahorarios.domine.repositories.SubjectRepository;
import com.sistemahorarios.service.interfaces.GroupService;
import com.sistemahorarios.service.mapper.GroupMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;
    private final ScheduleRepository scheduleRepository;

    @Override
    public GroupResponse create(GroupCreateRequest request) {
        Subject subject = subjectRepository.findById(request.subjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + request.subjectId()));
        Professor professor = professorRepository.findById(request.professorId())
                .orElseThrow(() -> new EntityNotFoundException("Professor not found with id: " + request.professorId()));
        Schedule schedule = scheduleRepository.findById(request.scheduleId())
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + request.scheduleId()));

        Group group = GroupMapper.toEntity(request, subject, professor, schedule);
        Group saved = groupRepository.save(group);
        return GroupMapper.toResponse(saved);
    }

    @Override
    public GroupResponse update(UUID id, GroupUpdateRequest request) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found with id: " + id));

        Subject subject = subjectRepository.findById(request.subjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + request.subjectId()));
        Professor professor = professorRepository.findById(request.professorId())
                .orElseThrow(() -> new EntityNotFoundException("Professor not found with id: " + request.professorId()));
        Schedule schedule = scheduleRepository.findById(request.scheduleId())
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + request.scheduleId()));

        GroupMapper.updateEntity(group, request, subject, professor, schedule);
        Group saved = groupRepository.save(group);
        return GroupMapper.toResponse(saved);
    }


    @Override
    public void delete(UUID id) {
        if (!groupRepository.existsById(id)) {
            throw new EntityNotFoundException("Group not found with id: " + id);
        }
        groupRepository.deleteById(id);
    }

    @Override
    public GroupResponse findById(UUID id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found with id: " + id));
        return GroupMapper.toResponse(group);
    }

    @Override
    public List<GroupResponse> findAll() {
        return groupRepository.findAll().stream()
                .map(GroupMapper::toResponse)
                .toList();
    }

    @Override
    public List<GroupResponse> findBySubject(UUID subjectId) {
        return groupRepository.findBySubjectId(subjectId).stream()
                .map(GroupMapper::toResponse)
                .toList();
    }

    @Override
    public List<GroupResponse> findByProfessor(UUID professorId) {
        return groupRepository.findByProfessorId(professorId).stream()
                .map(GroupMapper::toResponse)
                .toList();
    }

    @Override
    public List<GroupResponse> findBySchedule(UUID scheduleId) {
        return groupRepository.findByScheduleId(scheduleId).stream()
                .map(GroupMapper::toResponse)
                .toList();
    }

    @Override
    public List<GroupResponse> findByModality(Modality modality) {
        return groupRepository.findByModality(modality).stream()
                .map(GroupMapper::toResponse)
                .toList();
    }
}