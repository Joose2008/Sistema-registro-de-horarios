package com.sistemahorarios.service.mapper;

import com.sistemahorarios.api_dto.GroupDtos.GroupCreateRequest;
import com.sistemahorarios.api_dto.GroupDtos.GroupResponse;
import com.sistemahorarios.api_dto.GroupDtos.GroupUpdateRequest;
import com.sistemahorarios.domine.entities.Group;
import com.sistemahorarios.domine.entities.Professor;
import com.sistemahorarios.domine.entities.Schedule;
import com.sistemahorarios.domine.entities.Class;

public class GroupMapper {

    // El service debe resolver classesId/professorId/scheduleId contra sus
    // repositorios antes de llamar a este metodo; el mapper no consulta la BD.
    public static Group toEntity(GroupCreateRequest request, Class c,
                                 Professor professor, Schedule schedule) {
        return Group.builder()
                .classes(c)
                .professor(professor)
                .schedule(schedule)
                .modality(request.modality())
                .build();
    }

    public static void updateEntity(Group g, GroupUpdateRequest request, Class c,
                                    Professor professor, Schedule schedule) {
        g.setClasses(c);
        g.setProfessor(professor);
        g.setSchedule(schedule);
        g.setModality(request.modality());
    }

    public static GroupResponse toResponse(Group g) {
        return new GroupResponse(
                g.getId(),
                g.getClasses().getId(),
                g.getProfessor().getId(),
                g.getSchedule().getId(),
                g.getModality()
        );
    }
}