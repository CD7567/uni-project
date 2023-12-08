package com.cd7567.uni.repository;

import com.cd7567.uni.model.ScoreBoardRecord;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

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

    @Transactional
    public Long update(ScoreBoardRecord scoreRecord) {
        persist(scoreRecord);
        return scoreRecord.getId();
    }
}
