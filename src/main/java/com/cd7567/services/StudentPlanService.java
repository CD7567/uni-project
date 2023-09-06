package com.cd7567.services;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.dto.studentplan.StudentPlanMapper;
import com.cd7567.dto.studentplan.StudentPlanPutDTO;
import com.cd7567.entities.Course;
import com.cd7567.entities.StudentPlanRecord;
import com.cd7567.repositories.StudentPlanRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentPlanService {
    @Inject
    StudentPlanMapper studentPlanMapper;

    @Inject
    StudentPlanRepo studentPlanRepo;

    @Transactional
    public Long persistFromDTO(StudentPlanPutDTO dto) {
        StudentPlanRecord studentPlanRecord = studentPlanMapper.fromPutDTO(dto);
        studentPlanRepo.persist(studentPlanRecord);
        return studentPlanRecord.getId();
    }
}
