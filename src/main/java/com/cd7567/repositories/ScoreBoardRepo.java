package com.cd7567.repositories;

import com.cd7567.entities.ScoreBoardRecord;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ScoreBoardRepo implements PanacheRepository<ScoreBoardRecord> {
    public List<ScoreBoardRecord> getByStudentId(Long id) {
        return find(
                """
                SELECT re
                FROM ScoreBoardRecord re
                     JOIN FETCH re.student st
                WHERE st.id = ?1
                """, id
        ).list();
    }

    public List<ScoreBoardRecord> getByGroupId(Long id) {
        return find(
                """
                SELECT re
                FROM ScoreBoardRecord re
                     JOIN FETCH re.student st
                     JOIN FETCH st.group g
                WHERE g.id = ?1
                """, id
        ).list();
    }
}
