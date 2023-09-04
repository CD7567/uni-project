package com.cd7567.repositories;

import com.cd7567.entities.Direction;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DirectionRepo implements PanacheRepository<Direction> {
}
