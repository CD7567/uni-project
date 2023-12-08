package com.cd7567.uni.service;

import com.cd7567.uni.model.ScoreBoardRecord;
import com.cd7567.uni.model.api.scoreboard.ScoreBriefGetDTO;
import com.cd7567.uni.model.api.scoreboard.ScorePutDTO;
import com.cd7567.uni.model.api.scoreboard.ScoreStudentGetDTO;
import com.cd7567.uni.model.mapper.ScoreMapper;
import com.cd7567.uni.repository.ScoreBoardRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ScoreBoardService {
    @Inject
    ScoreMapper scoreMapper;

    @Inject
    ScoreBoardRepo scoreBoardRepo;

    public List<ScoreBriefGetDTO> getByStudentId(Long studentId) {
        return scoreMapper.toBriefDTO(scoreBoardRepo.getByStudentId(studentId));
    }

    public List<ScoreStudentGetDTO> getByGroupId(Long groupId) {
        return scoreMapper.toStudentDTO(scoreBoardRepo.getByGroupId(groupId));
    }

    @Transactional
    public Long persistFromDTO(ScorePutDTO dto) {
        ScoreBoardRecord scoreBoardRecord = scoreMapper.fromPutDTO(dto);
        scoreBoardRepo.persist(scoreBoardRecord);
        return scoreBoardRecord.getId();
    }
}
