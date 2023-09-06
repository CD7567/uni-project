package com.cd7567.services;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.dto.subject.SubjectInfoGetDTO;
import com.cd7567.dto.subject.SubjectMapper;
import com.cd7567.dto.subject.SubjectPutDTO;
import com.cd7567.entities.Course;
import com.cd7567.entities.Subject;
import com.cd7567.repositories.SubjectRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class SubjectService {
    @Inject
    SubjectMapper subjectMapper;

    @Inject
    SubjectRepo subjectRepo;

    public List<SubjectInfoGetDTO> getByFacultyId(Long facultyId) {
        return subjectMapper.toInfoDTO(subjectRepo.getByFacultyId(facultyId));
    }

    public List<SubjectInfoGetDTO> getByDirectionId(Long directionId) {
        return subjectMapper.toInfoDTO(subjectRepo.getByDirectionId(directionId));
    }

    public List<SubjectInfoGetDTO> getByCourseId(Long courseId) {
        return subjectMapper.toInfoDTO(subjectRepo.getByCourseId(courseId));
    }

    @Transactional
    public Long persistFromDTO(SubjectPutDTO dto) {
        Subject subject = subjectMapper.fromPutDTO(dto);
        subjectRepo.persist(subject);
        return subject.getId();
    }
}
