package com.cd7567.uni.repository;

import com.cd7567.uni.model.Faculty;
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
