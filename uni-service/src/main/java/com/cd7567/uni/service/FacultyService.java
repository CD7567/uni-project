package com.cd7567.uni.service;

import com.cd7567.uni.model.Faculty;
import com.cd7567.uni.model.api.faculty.*;
import com.cd7567.uni.model.mapper.FacultyMapper;
import com.cd7567.uni.repository.FacultyRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FacultyService {
    @Inject
    FacultyMapper facultyMapper;

    @Inject
    FacultyRepo facultyRepo;

    public List<FacultyBriefGetDTO> getFacultiesBriefDTO() {
        return facultyMapper.toBriefDTO(facultyRepo.listAll());
    }

    public List<FacultyCourseGetDTO> getFacultiesCourseDTO() {
        return facultyMapper.toCourseDTO(facultyRepo.listAll());
    }

    public List<FacultyDirGetDTO> getFacultiesDirDTO() {
        return facultyMapper.toDirDTO(facultyRepo.listAll());
    }

    public List<FacultySubjectGetDTO> getFacultiesSubjectDTO() {
        return facultyMapper.toSubjectDTO(facultyRepo.listAll());
    }

    @Transactional
    public Long persistFromDTO(FacultyPutDTO dto) {
        Faculty faculty = facultyMapper.fromPutDTO(dto);
        facultyRepo.persist(faculty);
        return faculty.getId();
    }
}
