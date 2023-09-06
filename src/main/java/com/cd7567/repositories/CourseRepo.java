package com.cd7567.repositories;

import com.cd7567.entities.Course;
import com.cd7567.entities.Direction;
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
