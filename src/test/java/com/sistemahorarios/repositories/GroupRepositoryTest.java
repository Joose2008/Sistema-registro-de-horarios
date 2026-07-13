package com.sistemahorarios.repositories;

import com.sistemahorarios.domine.entities.Group;
import com.sistemahorarios.domine.entities.Professor;
import com.sistemahorarios.domine.entities.Schedule;
import com.sistemahorarios.domine.entities.Subject;
import com.sistemahorarios.domine.enums.Modality;
import com.sistemahorarios.domine.repositories.ScheduleRepository;
import com.sistemahorarios.domine.repositories.SubjectRepository;
import com.sistemahorarios.domine.repositories.GroupRepository;
import com.sistemahorarios.domine.repositories.ProfessorRepository;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupRepositoryTest extends AbstractRepositoryIT{
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    @Test
    @DisplayName("")
    void shouldFindByModality() {
        Subject subjectTest = Subject.builder().name("Calculus").description("Integral Calculus").creditsNumber(4).build();
        Professor professorTest = Professor.builder().name("Chachuto").build();
        Schedule scheduleTest = Schedule.builder().start(LocalTime.of(9, 0)).end(LocalTime.of(11, 0)).day_of_week(DayOfWeek.FRIDAY).build();
        subjectRepository.save(subjectTest);
        professorRepository.save(professorTest);
        scheduleRepository.save(scheduleTest);

        groupRepository.save(Group.builder().modality(Modality.IN_PERSON).professor(professorTest).schedule(scheduleTest).subject(subjectTest).build());

        var groups = groupRepository.findByModality(Modality.IN_PERSON);
        assertThat(groups).isNotEmpty();
        assertThat(groups.get(0).getSubject()).isEqualTo(subjectTest);

    }

    @Test
    @DisplayName("shouldReturnEmptyWhenNoGroupsForModality")
    void shouldReturnEmptyWhenNoGroupsForModality() {
        Subject subjectTest = Subject.builder().name("Physics").description("Mechanics").creditsNumber(3).build();
        Professor professorTest = Professor.builder().name("Lopez").build();
        Schedule scheduleTest = Schedule.builder().start(LocalTime.of(8, 0)).end(LocalTime.of(10, 0)).day_of_week(DayOfWeek.MONDAY).build();
        subjectRepository.save(subjectTest);
        professorRepository.save(professorTest);
        scheduleRepository.save(scheduleTest);

        groupRepository.save(Group.builder().modality(Modality.IN_PERSON).professor(professorTest).schedule(scheduleTest).subject(subjectTest).build());

        var groups = groupRepository.findByModality(Modality.VIRTUAL);
        assertThat(groups).isEmpty();
    }

    @Test
    @DisplayName("shouldFindByProfessorId")
    void shouldFindByProfessorId() {
        Subject subjectTest = Subject.builder().name("Algebra").description("Linear Algebra").creditsNumber(4).build();
        Professor professorTest = Professor.builder().name("Chachuto").build();
        Schedule scheduleTest = Schedule.builder().start(LocalTime.of(10, 0)).end(LocalTime.of(12, 0)).day_of_week(DayOfWeek.WEDNESDAY).build();
        subjectRepository.save(subjectTest);
        professorRepository.save(professorTest);
        scheduleRepository.save(scheduleTest);

        groupRepository.save(Group.builder().modality(Modality.VIRTUAL).professor(professorTest).schedule(scheduleTest).subject(subjectTest).build());

        var groups = groupRepository.findByProfessorId(professorTest.getId());
        assertThat(groups).isNotEmpty();
        assertThat(groups).hasSize(1);
        assertThat(groups.get(0).getProfessor()).isEqualTo(professorTest);
    }

    @Test
    @DisplayName("shouldReturnEmptyWhenNoGroupsForProfessor")
    void shouldReturnEmptyWhenNoGroupsForProfessor() {
        var groups = groupRepository.findByProfessorId(UUID.randomUUID());
        assertThat(groups).isEmpty();
    }

    @Test
    @DisplayName("shouldFindBySubjectId")
    void shouldFindBySubjectId() {
        Subject subjectTest = Subject.builder().name("Chemistry").description("Organic Chemistry").creditsNumber(3).build();
        Professor professorTest = Professor.builder().name("Garcia").build();
        Schedule scheduleTest = Schedule.builder().start(LocalTime.of(14, 0)).end(LocalTime.of(16, 0)).day_of_week(DayOfWeek.TUESDAY).build();
        subjectRepository.save(subjectTest);
        professorRepository.save(professorTest);
        scheduleRepository.save(scheduleTest);

        groupRepository.save(Group.builder().modality(Modality.IN_PERSON).professor(professorTest).schedule(scheduleTest).subject(subjectTest).build());

        var groups = groupRepository.findBySubjectId(subjectTest.getId());
        assertThat(groups).isNotEmpty();
        assertThat(groups).hasSize(1);
        assertThat(groups.get(0).getSubject()).isEqualTo(subjectTest);
    }

    @Test
    @DisplayName("shouldReturnEmptyWhenNoGroupsForSubject")
    void shouldReturnEmptyWhenNoGroupsForSubject() {
        var groups = groupRepository.findBySubjectId(UUID.randomUUID());
        assertThat(groups).isEmpty();
    }
}
