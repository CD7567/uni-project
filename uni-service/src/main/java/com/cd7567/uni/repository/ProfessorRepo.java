package com.cd7567.uni.repository;

import com.cd7567.uni.model.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

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

    @Transactional
    public Long update(Professor professor) {
        persist(professor);
        return professor.getId();
    }
}
