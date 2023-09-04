package com.cd7567.dto.faculty;

import com.cd7567.dto.direction.DirectionMapper;
import com.cd7567.dto.professor.ProfessorMapper;
import com.cd7567.entities.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = {
                ProfessorMapper.class,
                DirectionMapper.class
        }
)
public interface FacultyMapper {
    @Mapping(target = "id", source = "faculty.id")
    @Mapping(target = "name", source = "faculty.name")
    @Mapping(target = "director", source = "faculty.director")
    FacultyBriefGetDTO toBriefDTO(Faculty faculty);

    List<FacultyBriefGetDTO> toBriefDTO(List<Faculty> faculties);
    Set<FacultyBriefGetDTO> toBriefDTO(Set<Faculty> faculties);

    @Mapping(target = "id", source = "faculty.id")
    @Mapping(target = "name", source = "faculty.name")
    @Mapping(target = "director", source = "faculty.director")
    @Mapping(target = "directions", source = "faculty.directions")
    FacultyCourseGetDTO toCourseDTO(Faculty faculty);

    List<FacultyCourseGetDTO> toCourseDTO(List<Faculty> faculties);
    Set<FacultyCourseGetDTO> toCourseDTO(Set<Faculty> faculties);

    @Mapping(target = "id", source = "faculty.id")
    @Mapping(target = "name", source = "faculty.name")
    @Mapping(target = "director", source = "faculty.director")
    @Mapping(target = "directions", source = "faculty.directions")
    FacultyDirGetDTO toDirDTO(Faculty faculty);

    List<FacultyDirGetDTO> toDirDTO(List<Faculty> faculties);
    Set<FacultyDirGetDTO> toDirDTO(Set<Faculty> faculties);

    @Mapping(target = "id", source = "faculty.id")
    @Mapping(target = "name", source = "faculty.name")
    @Mapping(target = "director", source = "faculty.director")
    @Mapping(target = "directions", source = "faculty.directions")
    FacultySubjectGetDTO toSubjectDTO(Faculty faculty);

    List<FacultySubjectGetDTO> toSubjectDTO(List<Faculty> faculties);
    Set<FacultySubjectGetDTO> toSubjectDTO(Set<Faculty> faculties);
}
