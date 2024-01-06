package com.cd7567.uni.model.mapper;

import com.cd7567.uni.model.StudentPlanRecord;
import com.cd7567.uni.model.api.studentplan.StudentPlanGetDTO;
import com.cd7567.uni.model.api.studentplan.StudentPlanPutDTO;
import com.cd7567.uni.repository.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = ReferenceLoader.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StudentPlanMapper {
    @Mapping(target = "id", source = "record.id")
    @Mapping(target = "subject", source = "record.subject")
    com.cd7567.uni.model.api.entities.StudentPlanRecord toDTO(StudentPlanRecord record);
    /*
    @Mapping(target = "id", source = "record.id")
    @Mapping(target = "lecturerId", source = "record.lecturer.id")
    @Mapping(target = "seminaristId", source = "record.seminarist.id")
    @Mapping(target = "studentId", source = "record.student.id")
    @Mapping(target = "subjectId", source = "record.subject.id")
    StudentPlanGetDTO toDTO(StudentPlanRecord record);

     */

    List<StudentPlanGetDTO> toDTO(List<StudentPlanRecord> records);
    Set<StudentPlanGetDTO> toDTO(Set<StudentPlanRecord> records);


    @Mapping(target = "id", source = "dto.id")
    @Mapping(
            target = "lecturer",
            source = "dto.lecturerId",
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
