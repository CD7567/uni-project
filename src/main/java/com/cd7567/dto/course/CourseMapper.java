package com.cd7567.dto.course;

import com.cd7567.dto.subject.SubjectMapper;
import com.cd7567.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = SubjectMapper.class
)
public interface CourseMapper {
    @Mapping(target = "id", source = "course.id")
    @Mapping(target = "name", source = "course.name")
    CourseBriefGetDTO toBriefDTO(Course course);

    List<CourseBriefGetDTO> toBriefDTO(List<Course> course);
    Set<CourseBriefGetDTO> toBriefDTO(Set<Course> course);

    @Mapping(target = "id", source = "course.id")
    @Mapping(target = "name", source = "course.name")
    @Mapping(target = "subjects", source = "course.subjects")
    CourseSubjectGetDTO toSubjectDTO(Course course);

    List<CourseSubjectGetDTO> toSubjectDTO(List<Course> course);
    Set<CourseSubjectGetDTO> toSubjectDTO(Set<Course> course);
}
