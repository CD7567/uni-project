package com.cd7567.uni.service;

import com.cd7567.uni.model.StudentPlanRecord;
import com.cd7567.uni.model.api.studentplan.StudentPlanPutDTO;
import com.cd7567.uni.model.mapper.StudentPlanMapper;
import com.cd7567.uni.repository.StudentPlanRepo;
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
