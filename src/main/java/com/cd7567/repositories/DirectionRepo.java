package com.cd7567.repositories;

import com.cd7567.entities.Course;
import com.cd7567.entities.Direction;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DirectionRepo implements PanacheRepository<Direction> {
    @Transactional
    public Long update(Direction direction) {
        persist(direction);
        return direction.getId();
    }
}
