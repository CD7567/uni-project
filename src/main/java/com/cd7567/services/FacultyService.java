package com.cd7567.services;

import com.cd7567.dto.faculty.*;
import com.cd7567.repositories.FacultyRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FacultyService {
    @Inject
    FacultyMapper mapper;

    @Inject
    FacultyRepo facultyRepo;

    public List<FacultyBriefGetDTO> getFacultiesBriefDTO() {
        return mapper.toBriefDTO(facultyRepo.listAll());
    }

    public List<FacultyCourseGetDTO> getFacultiesCourseDTO() {
        return mapper.toCourseDTO(facultyRepo.listAll());
    }

    public List<FacultyDirGetDTO> getFacultiesDirDTO() {
        return mapper.toDirDTO(facultyRepo.listAll());
    }

    public List<FacultySubjectGetDTO> getFacultiesSubjectDTO() {
        return mapper.toSubjectDTO(facultyRepo.listAll());
    }
}
