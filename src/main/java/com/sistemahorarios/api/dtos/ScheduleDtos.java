package com.sistemahorarios.api.dtos;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public class ScheduleDtos {
    public record ScheduleCreateRequest(
            DayOfWeek day_of_week,
            LocalTime start,
            LocalTime end
    ) implements Serializable {}

    public record ScheduleUpdateRequest(
            DayOfWeek day_of_week,
            LocalTime start,
            LocalTime end
    ) implements Serializable {}

    public record ScheduleResponse(
            UUID id,
            DayOfWeek day_of_week,
            LocalTime start,
            LocalTime end
    ) implements Serializable {}
}
