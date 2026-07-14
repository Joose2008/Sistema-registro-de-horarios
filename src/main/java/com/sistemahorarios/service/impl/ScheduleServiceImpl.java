package com.sistemahorarios.service.impl;

import com.sistemahorarios.api.dtos.ScheduleDtos.*;
import com.sistemahorarios.domine.entities.Schedule;
import com.sistemahorarios.domine.repositories.ScheduleRepository;
import com.sistemahorarios.service.interfaces.ScheduleService;
import com.sistemahorarios.service.mapper.ScheduleMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponse create(ScheduleCreateRequest request) {
        Schedule schedule = ScheduleMapper.toEntity(request);
        Schedule saved = scheduleRepository.save(schedule);
        return ScheduleMapper.toResponse(saved);
    }

    @Override
    public ScheduleResponse update(UUID id, ScheduleUpdateRequest request) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));
        ScheduleMapper.updateEntity(schedule, request);
        Schedule saved = scheduleRepository.save(schedule);
        return ScheduleMapper.toResponse(saved);
    }

    @Override
    public void delete(UUID id) {
        if (!scheduleRepository.existsById(id)) {
            throw new EntityNotFoundException("Schedule not found with id: " + id);
        }
        scheduleRepository.deleteById(id);
    }

    @Override
    public ScheduleResponse findById(UUID id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));
        return ScheduleMapper.toResponse(schedule);
    }

    @Override
    public List<ScheduleResponse> findAll() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleMapper::toResponse)
                .toList();
    }

    @Override
    public List<ScheduleResponse> findByDayOfWeek(DayOfWeek dayOfWeek) {
        return scheduleRepository.findByDayOfWeek(dayOfWeek).stream()
                .map(ScheduleMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<ScheduleResponse> hasExisting(UUID id) {
        return scheduleRepository.findById(id)
                .map(ScheduleMapper::toResponse);
    }
}