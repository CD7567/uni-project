package com.cd7567.uni.repository;

import com.cd7567.uni.model.Course;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CourseRepo implements PanacheRepository<Course> {
    @Transactional
    public Long update(Course course) {
        persist(course);
        return course.getId();
    }
}
