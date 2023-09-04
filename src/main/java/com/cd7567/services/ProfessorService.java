package com.cd7567.services;

import com.cd7567.dto.professor.ProfessorBriefGetDTO;
import com.cd7567.dto.professor.ProfessorMapper;
import com.cd7567.repositories.ProfessorRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProfessorService {
    @Inject
    ProfessorRepo professorRepo;

    @Inject
    ProfessorMapper professorMapper;

    public List<ProfessorBriefGetDTO> getBrief() {
        return professorMapper.toBriefDTO(professorRepo.listAll());
    }

    public List<ProfessorBriefGetDTO> getLecturersBySubjectId(Long id) {
        return professorMapper.toBriefDTO(professorRepo.getLecturersBySubjectId(id));
    }

    public List<ProfessorBriefGetDTO> getSeminaristsBySubjectId(Long id) {
        return professorMapper.toBriefDTO(professorRepo.getSeminaristsBySubjectId(id));
    }
}
