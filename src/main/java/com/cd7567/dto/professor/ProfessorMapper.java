package com.cd7567.dto.professor;

import com.cd7567.entities.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta"
)
public interface ProfessorMapper {
    @Mapping(target = "id", source = "professor.id")
    @Mapping(target = "name", expression = "java(professor.getFirstName() + ' ' + professor.getLastName())")
    ProfessorBriefGetDTO toBriefDTO(Professor professor);

    List<ProfessorBriefGetDTO> toBriefDTO(List<Professor> professors);
    Set<ProfessorBriefGetDTO> toBriefDTO(Set<Professor> professors);
}
