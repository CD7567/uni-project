package com.cd7567.services;

import com.cd7567.dto.scoreboard.ScoreBriefGetDTO;
import com.cd7567.dto.scoreboard.ScoreMapper;
import com.cd7567.dto.scoreboard.ScoreStudentGetDTO;
import com.cd7567.repositories.ScoreBoardRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
}
