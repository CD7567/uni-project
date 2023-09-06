package com.cd7567.dto.scoreboard;

import com.cd7567.entities.ScoreBoardRecord;
import com.cd7567.repositories.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = ReferenceLoader.class
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

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "mark", source = "dto.mark")
    @Mapping(
            target = "student",
            source = "dto.studentId",
            qualifiedByName = {"ReferenceLoader", "getStudentReferenceById"}
    )
    @Mapping(
            target = "subject",
            source = "dto.subjectId",
            qualifiedByName = {"ReferenceLoader", "getSubjectReferenceById"}
    )
    ScoreBoardRecord fromPutDTO(ScorePutDTO dto);

    List<ScoreBoardRecord> fromPutDTO(List<ScorePutDTO> dto);
    Set<ScoreBoardRecord> fromPutDTO(Set<ScorePutDTO> dto);
}
