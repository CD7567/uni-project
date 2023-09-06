package com.cd7567.repositories;

import com.cd7567.entities.Direction;
import com.cd7567.entities.Group;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GroupRepo implements PanacheRepository<Group> {
    @Transactional
    public Long update(Group group) {
        persist(group);
        return group.getId();
    }
}
