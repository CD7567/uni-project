package com.cd7567.dto.direction;

import com.cd7567.dto.course.CourseMapper;
import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.entities.Course;
import com.cd7567.entities.Direction;
import com.cd7567.repositories.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = {
                CourseMapper.class,
                ReferenceLoader.class
        }
)
public interface DirectionMapper {
    @Mapping(target = "id", source = "direction.id")
    @Mapping(target = "name", source = "direction.name")
    DirectionBriefGetDTO toBriefDTO(Direction direction);

    List<DirectionBriefGetDTO> toBriefDTO(List<Direction> directions);
    Set<DirectionBriefGetDTO> toBriefDTO(Set<Direction> directions);
    @Mapping(target = "id", source = "direction.id")
    @Mapping(target = "name", source = "direction.name")
    @Mapping(target = "courses", source = "direction.courses")
    DirectionCourseGetDTO toCourseDTO(Direction direction);

    List<DirectionCourseGetDTO> toCourseDTO(List<Direction> directions);
    Set<DirectionCourseGetDTO> toCourseDTO(Set<Direction> directions);

    @Mapping(target = "id", source = "direction.id")
    @Mapping(target = "name", source = "direction.name")
    @Mapping(target = "courses", source = "direction.courses")
    DirectionSubjectGetDTO toSubjectDTO(Direction direction);

    List<DirectionSubjectGetDTO> toSubjectDTO(List<Direction> directions);
    Set<DirectionSubjectGetDTO> tSubjectDTO(Set<Direction> directions);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "number", source = "dto.number")
    @Mapping(
            target = "faculty",
            source = "dto.facultyId",
            qualifiedByName = {"ReferenceLoader", "getFacultyReferenceById"}
    )
    @Mapping(
            target = "groups",
            source = "dto.groupIds",
            qualifiedByName = {"ReferenceLoader", "getGroupReferenceById"}
    )
    @Mapping(
            target = "courses",
            source = "dto.courseIds",
            qualifiedByName = {"ReferenceLoader", "getCourseReferenceById"}
    )
    Direction fromPutDTO(DirectionPutDTO dto);

    List<Direction> fromPutDTO(List<DirectionPutDTO> dto);
    Set<Direction> fromPutDTO(Set<DirectionPutDTO> dto);
}
