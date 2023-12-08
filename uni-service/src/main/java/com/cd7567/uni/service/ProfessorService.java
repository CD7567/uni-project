package com.cd7567.uni.service;

import com.cd7567.uni.model.Professor;
import com.cd7567.uni.model.api.professor.ProfessorBriefGetDTO;
import com.cd7567.uni.model.api.professor.ProfessorPutDTO;
import com.cd7567.uni.model.mapper.ProfessorMapper;
import com.cd7567.uni.repository.ProfessorRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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

    @Transactional
    public Long persistFromDTO(ProfessorPutDTO dto) {
        Professor professor = professorMapper.fromPutDTO(dto);
        if (professor.getVersion() == null) professor.setVersion(1L);
        professorRepo.persist(professor);
        return professor.getId();
    }
}
