package com.cd7567.uni.service;

import com.cd7567.uni.model.Direction;
import com.cd7567.uni.model.api.direction.DirectionPutDTO;
import com.cd7567.uni.model.mapper.DirectionMapper;
import com.cd7567.uni.repository.DirectionRepo;
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
