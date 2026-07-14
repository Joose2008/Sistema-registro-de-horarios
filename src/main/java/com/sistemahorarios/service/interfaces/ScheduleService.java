package com.sistemahorarios.service.interfaces;

import com.sistemahorarios.api.dtos.ScheduleDtos.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScheduleService {
    ScheduleResponse create(ScheduleCreateRequest request);
    ScheduleResponse update(UUID id, ScheduleUpdateRequest request);


    void delete(UUID id);
    ScheduleResponse findById(UUID uuid);
    List<ScheduleResponse> findAll();

    List<ScheduleResponse> findByDayOfWeek(DayOfWeek dayOfWeek);
    Optional<ScheduleResponse> hasExisting(UUID id);

}
