package com.cd7567.uni.repository;

import com.cd7567.uni.model.Direction;
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
