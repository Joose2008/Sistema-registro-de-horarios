package com.sistemahorarios.service.impl;

import com.sistemahorarios.api.dtos.SubjectDtos.*;
import com.sistemahorarios.domine.entities.Subject;
import com.sistemahorarios.domine.repositories.SubjectRepository;
import com.sistemahorarios.service.interfaces.SubjectService;
import com.sistemahorarios.service.mapper.SubjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public SubjectResponse create(SubjectCreateRequest request) {
        Subject subject = SubjectMapper.toEntity(request);
        Subject saved = subjectRepository.save(subject);
        return SubjectMapper.toResponse(saved);
    }

    @Override
    public SubjectResponse findById(UUID id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + id));
        return SubjectMapper.toResponse(subject);
    }

    @Override
    public void delete(UUID id) {
        if (!subjectRepository.existsById(id)) {
            throw new EntityNotFoundException("Subject not found with id: " + id);
        }
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectResponse update(UUID id, SubjectUpdateRequest request) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found with id: " + id));
        SubjectMapper.patch(subject, request);
        Subject saved = subjectRepository.save(subject);
        return SubjectMapper.toResponse(saved);
    }
}