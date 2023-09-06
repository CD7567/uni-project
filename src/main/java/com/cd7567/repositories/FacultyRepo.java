package com.cd7567.repositories;

import com.cd7567.entities.Course;
import com.cd7567.entities.Direction;
import com.cd7567.entities.Faculty;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FacultyRepo implements PanacheRepository<Faculty> {
    @Transactional
    public Long update(Faculty faculty) {
        persist(faculty);
        return faculty.getId();
    }
}
