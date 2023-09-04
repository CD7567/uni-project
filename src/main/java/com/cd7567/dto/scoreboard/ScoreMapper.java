package com.cd7567.dto.scoreboard;

import com.cd7567.entities.ScoreBoardRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta"
)
public interface ScoreMapper {
    @Mapping(target = "id", source = "record.id")
    @Mapping(target = "studentId", source = "record.student.id")
    @Mapping(target = "subjectId", source = "record.subject.id")
    @Mapping(target = "mark", source = "record.mark")
    ScoreBriefGetDTO toBriefDTO(ScoreBoardRecord record);

    List<ScoreBriefGetDTO> toBriefDTO(List<ScoreBoardRecord> records);
    Set<ScoreBriefGetDTO> toBriefDTO(Set<ScoreBoardRecord> records);

    @Mapping(target = "id", source = "record.id")
    @Mapping(target = "studentId", source = "record.student.id")
    @Mapping(target = "studentName", expression = "java(record.getStudent().getFirstName() + ' ' + record.getStudent().getLastName())")
    @Mapping(target = "subjectId", source = "record.subject.id")
    @Mapping(target = "mark", source = "record.mark")
    ScoreStudentGetDTO toStudentDTO(ScoreBoardRecord record);

    List<ScoreStudentGetDTO> toStudentDTO(List<ScoreBoardRecord> records);
    Set<ScoreStudentGetDTO> toStudentDTO(Set<ScoreBoardRecord> records);
}
