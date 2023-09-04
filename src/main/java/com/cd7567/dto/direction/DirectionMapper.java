package com.cd7567.dto.direction;

import com.cd7567.dto.course.CourseMapper;
import com.cd7567.entities.Direction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = CourseMapper.class
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
}
