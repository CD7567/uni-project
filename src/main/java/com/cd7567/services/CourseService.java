package com.cd7567.services;

import com.cd7567.dto.course.CourseMapper;
import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.entities.Course;
import com.cd7567.repositories.CourseRepo;
import io.quarkus.hibernate.orm.PersistenceUnitExtension;
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
