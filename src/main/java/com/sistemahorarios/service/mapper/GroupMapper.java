package com.sistemahorarios.service.mapper;


import com.sistemahorarios.api.dtos.GroupDtos;
import com.sistemahorarios.domine.entities.Group;
import com.sistemahorarios.domine.entities.Professor;
import com.sistemahorarios.domine.entities.Schedule;
import com.sistemahorarios.domine.entities.Subject;

public class GroupMapper {

    // El service debe resolver classesId/professorId/scheduleId contra sus
    // repositorios antes de llamar a este metodo; el mapper no consulta la BD.
    public static Group toEntity(GroupDtos.GroupCreateRequest request, Subject c,
                                 Professor professor, Schedule schedule) {
        return Group.builder()
                .subject(c)
                .professor(professor)
                .schedule(schedule)
                .modality(request.modality())
                .build();
    }

    public static void updateEntity(Group g, GroupDtos.GroupUpdateRequest request, Subject c,
                                    Professor professor, Schedule schedule) {
        g.setSubject(c);
        g.setProfessor(professor);
        g.setSchedule(schedule);
        g.setModality(request.modality());
    }

    public static GroupDtos.GroupResponse toResponse(Group g) {
        return new GroupDtos.GroupResponse(
                g.getId(),
                g.getSubject().getId(),
                g.getProfessor().getId(),
                g.getSchedule().getId(),
                g.getModality()
        );
    }
}