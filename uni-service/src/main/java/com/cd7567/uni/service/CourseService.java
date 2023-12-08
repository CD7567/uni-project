package com.cd7567.uni.service;

import com.cd7567.uni.model.Course;
import com.cd7567.uni.model.api.course.CoursePutDTO;
import com.cd7567.uni.model.mapper.CourseMapper;
import com.cd7567.uni.repository.CourseRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CourseService {
    @Inject
    CourseMapper courseMapper;

    @Inject
    CourseRepo courseRepo;

    @Transactional
    public Long persistFromDTO(CoursePutDTO dto) {
        Course course = courseMapper.fromPutDTO(dto);
        courseRepo.persist(course);
        return course.getId();
    }
}