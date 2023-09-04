package com.cd7567.repositories;

import com.cd7567.entities.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {
    public List<Student> getByGroupId(Long groupId) {
        return find(
                """
                SELECT s
                FROM Student s
                    JOIN FETCH s.group g
                WHERE g.id = ?1
                """, groupId
                ).list();
    }

    public List<Student> getByTerm(Integer term) {
        return find(
                """
                SELECT s
                FROM Student s
                     JOIN FETCH s.group g
                WHERE g.term = ?1
                """, term
        ).list();
    }

    public List<Student> getByCourseId(Long courseId) {
        return find(
                """
                SELECT s
                FROM Student s
                     JOIN FETCH s.courses c
                WHERE c.id = ?1
                """, courseId
        ).list();
    }

    public List<Student> getBySubjectId(Long subjectId) {
        return find(
                """
                SELECT s
                FROM Student s
                     JOIN FETCH s.courses c
                     JOIN FETCH c.subjects sub
                WHERE sub.id = ?1
                """, subjectId
        ).list();
    }

    public List<Student> getBySeminaristId(Long id) {
        return find(
                """
                SELECT s
                FROM Student s
                     JOIN FETCH s.planItems it
                     JOIN FETCH it.seminarist sem
                WHERE sem.id = ?1
                """, id
        ).list();
    }

    public List<Student> getByLecturerId(Long id) {
        return find(
                """
                SELECT s
                FROM Student s
                     JOIN FETCH s.planItems it
                     JOIN FETCH it.lecturer lect
                WHERE lect.id = ?1
                """, id
        ).list();
    }
}
