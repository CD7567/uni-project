package com.cd7567.uni.service;

import com.cd7567.uni.model.Course;
import com.cd7567.uni.model.api.course.CoursePutDTO;
import com.cd7567.uni.model.api.structure.getcoursebyid.GetCourseByIdResult;
import com.cd7567.uni.model.mapper.CourseMapper;
import com.cd7567.uni.repository.CourseRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CourseService {
    @Inject
    CourseMapper courseMapper;

    @Inject
    CourseRepo courseRepo;

    @Transactional
    public GetCourseByIdResult getByIds(List<Long> ids) {
        GetCourseByIdResult result = new GetCourseByIdResult();
        result.setCourses(courseMapper.toDTO(courseRepo.getByIds(ids)));
        return result;
    }


    @Transactional
    public Long persistFromDTO(CoursePutDTO dto) {
        Course course = courseMapper.fromPutDTO(dto);
        courseRepo.persist(course);
        return course.getId();
    }
}
