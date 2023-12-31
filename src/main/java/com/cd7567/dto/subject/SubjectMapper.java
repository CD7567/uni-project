package com.cd7567.dto.subject;

import com.cd7567.dto.student.StudentPutDTO;
import com.cd7567.entities.Student;
import com.cd7567.entities.Subject;
import com.cd7567.repositories.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = ReferenceLoader.class
)
public interface SubjectMapper {
    @Mapping(target = "id", source = "subject.id")
    @Mapping(target = "name", source = "subject.name")
    SubjectBriefGetDTO toBriefDTO(Subject subject);

    List<SubjectBriefGetDTO> toBriefDTO(List<Subject> subjects);
    Set<SubjectBriefGetDTO> toBriefDTO(Set<Subject> subjects);

    @Mapping(target = "id", source = "subject.id")
    @Mapping(target = "name", source = "subject.name")
    @Mapping(target = "term", source = "subject.term")
    @Mapping(target = "hours", source = "subject.hours")
    @Mapping(target = "type", source = "subject.type")
    @Mapping(target = "markWay", source = "subject.markWay")
    SubjectInfoGetDTO toInfoDTO(Subject subject);

    List<SubjectInfoGetDTO> toInfoDTO(List<Subject> subjects);
    Set<SubjectInfoGetDTO> toInfoDTO(Set<Subject> subjects);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "term", source = "dto.term")
    @Mapping(target = "hours", source = "dto.hours")
    @Mapping(target = "type", source = "dto.type")
    @Mapping(target = "markWay", source = "dto.markWay")
    @Mapping(
            target = "course",
            source = "dto.courseId",
            qualifiedByName = {"ReferenceLoader", "getCourseReferenceById"}
    )
    @Mapping(
            target = "seminarists",
            source = "dto.seminaristIds",
            qualifiedByName = {"ReferenceLoader", "getProfessorReferenceById"}
    )
    @Mapping(
            target = "lecturers",
            source = "dto.lecturerIds",
            qualifiedByName = {"ReferenceLoader", "getProfessorReferenceById"}
    )
    Subject fromPutDTO(SubjectPutDTO dto);

    List<Subject> fromPutDTO(List<SubjectPutDTO> dto);
    Set<Subject> fromPutDTO(Set<SubjectPutDTO> dto);
}
