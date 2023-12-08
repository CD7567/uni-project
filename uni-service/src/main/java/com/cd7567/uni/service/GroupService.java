package com.cd7567.uni.service;

import com.cd7567.uni.model.Group;
import com.cd7567.uni.model.api.group.GroupPutDTO;
import com.cd7567.uni.model.mapper.GroupMapper;
import com.cd7567.uni.repository.GroupRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class GroupService {
    @Inject
    GroupMapper groupMapper;

    @Inject
    GroupRepo groupRepo;

    @Transactional
    public Long persistFromDTO(GroupPutDTO dto) {
        Group group = groupMapper.fromPutDTO(dto);
        groupRepo.persist(group);
        return group.getId();
    }
}
