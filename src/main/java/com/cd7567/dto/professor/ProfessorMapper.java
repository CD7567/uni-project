package com.cd7567.dto.professor;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.entities.Course;
import com.cd7567.entities.Professor;
import com.cd7567.repositories.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = ReferenceLoader.class
)
public interface ProfessorMapper {
    @Mapping(target = "id", source = "professor.id")
    @Mapping(target = "name", expression = "java(professor.getFirstName() + ' ' + professor.getLastName())")
    ProfessorBriefGetDTO toBriefDTO(Professor professor);

    List<ProfessorBriefGetDTO> toBriefDTO(List<Professor> professors);
    Set<ProfessorBriefGetDTO> toBriefDTO(Set<Professor> professors);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "position", source = "dto.position")
    @Mapping(
            target = "lectures",
            source = "dto.lectSubjectIds",
            qualifiedByName = {"ReferenceLoader", "getSubjectReferenceById"}
    )
    @Mapping(
            target = "seminars",
            source = "dto.semSubjectIds",
            qualifiedByName = {"ReferenceLoader", "getSubjectReferenceById"}
    )
    Professor fromPutDTO(ProfessorPutDTO dto);

    List<Professor> fromPutDTO(List<ProfessorPutDTO> dto);
    Set<Professor> fromPutDTO(Set<ProfessorPutDTO> dto);
}
