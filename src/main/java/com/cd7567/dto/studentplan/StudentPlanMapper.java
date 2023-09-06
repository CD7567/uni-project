package com.cd7567.dto.studentplan;

import com.cd7567.dto.scoreboard.ScoreBriefGetDTO;
import com.cd7567.entities.ScoreBoardRecord;
import com.cd7567.entities.StudentPlanRecord;
import com.cd7567.repositories.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = ReferenceLoader.class
)
public interface StudentPlanMapper {
    @Mapping(target = "id", source = "record.id")
    @Mapping(target = "lecturerId", source = "record.lecturer.id")
    @Mapping(target = "seminaristId", source = "record.seminarist.id")
    @Mapping(target = "studentId", source = "record.student.id")
    @Mapping(target = "subjectId", source = "record.subject.id")
    StudentPlanGetDTO toDTO(StudentPlanRecord record);

    List<StudentPlanGetDTO> toDTO(List<StudentPlanRecord> records);
    Set<StudentPlanGetDTO> toDTO(Set<StudentPlanRecord> records);


    @Mapping(target = "id", source = "dto.id")
    @Mapping(
            target = "lecturer",
            source = "record.lecturerId",
            qualifiedByName = {"ReferenceLoader", "getProfessorReferenceById"}
    )
    @Mapping(
            target = "seminarist",
            source = "dto.seminaristId",
            qualifiedByName = {"ReferenceLoader", "getProfessorReferenceById"}
    )
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
    StudentPlanRecord fromPutDTO(StudentPlanPutDTO dto);

    List<StudentPlanRecord> fromPutDTO(List<StudentPlanPutDTO> dto);
    Set<StudentPlanRecord> fromPutDTO(Set<StudentPlanPutDTO> dto);
}
