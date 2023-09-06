package com.cd7567.services;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.dto.group.GroupMapper;
import com.cd7567.dto.group.GroupPutDTO;
import com.cd7567.entities.Course;
import com.cd7567.entities.Group;
import com.cd7567.repositories.GroupRepo;
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
