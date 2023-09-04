package com.cd7567.repositories;

import com.cd7567.entities.Subject;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SubjectRepo implements PanacheRepository<Subject> {
    public List<Subject> getByFacultyId(Long facultyId) {
        return find(
                """
                SELECT s
                FROM Subject s
                     JOIN FETCH s.course c
                     JOIN FETCH c.direction d
                     JOIN FETCH d.faculty f
                WHERE f.id = ?1
                """, facultyId
        ).list();
    }

    public List<Subject> getByDirectionId(Long directionId) {
        return find(
                """
                SELECT s
                FROM Subject s
                     JOIN FETCH s.course c
                     JOIN FETCH c.direction d
                WHERE d.id = ?1
                """, directionId
        ).list();
    }

    public List<Subject> getByCourseId(Long courseId) {
        return find(
                """
                SELECT s
                FROM Subject s
                     JOIN FETCH s.course c
                WHERE c.id = ?1
                """, courseId
        ).list();
    }
}
