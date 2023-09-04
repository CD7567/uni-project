package com.cd7567.repositories;

import com.cd7567.entities.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProfessorRepo implements PanacheRepository<Professor> {
    public List<Professor> getLecturersBySubjectId(Long courseId) {
        return find(
                """
                SELECT p
                FROM Professor p
                     JOIN FETCH p.lectures subj
                WHERE subj.id = ?1
                """, courseId
        ).list();
    }

    public List<Professor> getSeminaristsBySubjectId(Long courseId) {
        return find(
                """
                SELECT p
                FROM Professor p
                     JOIN FETCH p.seminars subj
                WHERE subj.id = ?1
                """, courseId
        ).list();
    }
}
