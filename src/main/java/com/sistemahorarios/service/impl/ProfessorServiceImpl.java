package com.sistemahorarios.service.impl;

import com.sistemahorarios.api.dtos.ProfessorDtos.*;
import com.sistemahorarios.domine.entities.Professor;
import com.sistemahorarios.domine.repositories.ProfessorRepository;
import com.sistemahorarios.service.interfaces.ProfessorService;
import com.sistemahorarios.service.mapper.ProfessorMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public ProfessorResponse create(ProfessorCreateRequest request) {
        Professor professor = ProfessorMapper.toEntity(request);
        Professor saved = professorRepository.save(professor);
        return ProfessorMapper.toResponse(saved);
    }

    @Override
    public ProfessorResponse update(UUID id, ProfessorUpdateRequest request) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found with id: " + id));
        ProfessorMapper.updateEntity(professor, request);
        Professor saved = professorRepository.save(professor);
        return ProfessorMapper.toResponse(saved);
    }

    @Override
    public void delete(UUID id) {
        if (!professorRepository.existsById(id)) {
            throw new EntityNotFoundException("Professor not found with id: " + id);
        }
        professorRepository.deleteById(id);
    }

    @Override
    public ProfessorResponse findById(UUID id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found with id: " + id));
        return ProfessorMapper.toResponse(professor);
    }
}