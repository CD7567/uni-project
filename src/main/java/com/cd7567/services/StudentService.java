package com.cd7567.services;

import com.cd7567.dto.student.StudentBriefGetDTO;
import com.cd7567.dto.student.StudentInfoGetDTO;
import com.cd7567.dto.student.StudentMapper;
import com.cd7567.dto.student.StudentMarkGetDTO;
import com.cd7567.repositories.StudentRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class StudentService {
    @Inject
    StudentRepo studentRepo;

    @Inject
    StudentMapper studentMapper;

    public List<StudentBriefGetDTO> getBrief() {
        return studentMapper.toBriefDTO(studentRepo.listAll());
    }

    public List<StudentInfoGetDTO> getByGroupId(Long groupId) {
        return studentMapper.toInfoDTO(studentRepo.getByGroupId(groupId));
    }

    public List<StudentInfoGetDTO> getByTerm(Integer term) {
        return studentMapper.toInfoDTO(studentRepo.getByTerm(term));
    }

    public List<StudentInfoGetDTO> getByCourseId(Long courseId) {
        return studentMapper.toInfoDTO(studentRepo.getByCourseId(courseId));
    }

    public List<StudentInfoGetDTO> getBySubjectId(Long subjectId) {
        return studentMapper.toInfoDTO(studentRepo.getBySubjectId(subjectId));
    }

    public List<StudentMarkGetDTO> getBySeminaristId(Long id) {
        return studentMapper.toMarkDTO(studentRepo.getBySeminaristId(id));
    }

    public List<StudentMarkGetDTO> getByLecturerId(Long id) {
        return studentMapper.toMarkDTO(studentRepo.getByLecturerId(id));
    }
}
