package com.sistemahorarios.service.mapper;

import com.sistemahorarios.api_dto.ScheduleDtos;
import com.sistemahorarios.domine.entities.Schedule;

public class ScheduleMapper {

    public static Schedule toEntity(ScheduleDtos.ScheduleCreateRequest request) {
        return Schedule.builder()
                .day_of_week(request.day_of_week())
                .start(request.start())
                .end(request.end())
                .build();
    }

    public static void updateEntity(Schedule s, ScheduleDtos.ScheduleUpdateRequest request) {
        s.setDay_of_week(request.day_of_week());
        s.setStart(request.start());
        s.setEnd(request.end());
    }

    public static ScheduleDtos.ScheduleResponse toResponse(Schedule s) {
        return new ScheduleDtos.ScheduleResponse(
                s.getId(),
                s.getDay_of_week(),
                s.getStart(),
                s.getEnd()
        );
    }
}
