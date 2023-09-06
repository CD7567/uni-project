package com.cd7567.services;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.dto.direction.DirectionMapper;
import com.cd7567.dto.direction.DirectionPutDTO;
import com.cd7567.entities.Course;
import com.cd7567.entities.Direction;
import com.cd7567.repositories.DirectionRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DirectionService {
    @Inject
    DirectionMapper directionMapper;

    @Inject
    DirectionRepo directionRepo;

    @Transactional
    public Long persistFromDTO(DirectionPutDTO dto) {
        Direction direction = directionMapper.fromPutDTO(dto);
        directionRepo.persist(direction);
        return direction.getId();
    }
}
