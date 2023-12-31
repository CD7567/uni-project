package com.cd7567.services;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.dto.student.*;
import com.cd7567.entities.Course;
import com.cd7567.entities.Student;
import com.cd7567.repositories.StudentRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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

    @Transactional
    public Long persistFromDTO(StudentPutDTO dto) {
        Student student = studentMapper.fromPutDTO(dto);
        student.setVersion(1L);
        studentRepo.persist(student);
        return student.getId();
    }
}
