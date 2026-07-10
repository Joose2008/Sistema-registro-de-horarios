package com.sistemahorarios.domine.repositories;

import com.sistemahorarios.domine.entities.Group;
import com.sistemahorarios.domine.enums.Modality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
    List<Group> findByMateriaId(UUID materiaId);

    List<Group> findByProfessorId(UUID professorId);

    List<Group> findByModality(Modality modality);
}
