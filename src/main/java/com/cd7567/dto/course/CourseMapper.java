package com.cd7567.dto.course;

import com.cd7567.dto.subject.SubjectMapper;
import com.cd7567.entities.Course;
import com.cd7567.repositories.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = {
                SubjectMapper.class,
                ReferenceLoader.class
        }
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

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(
            target = "direction",
            source = "dto.directionId",
            qualifiedByName = {"ReferenceLoader", "getDirectionReferenceById"}
    )
    @Mapping(
            target = "subjects",
            source = "dto.subjectIds",
            qualifiedByName = {"ReferenceLoader", "getSubjectReferenceById"}
    )
    @Mapping(
            target = "chief",
            source = "dto.chiefId",
            qualifiedByName = {"ReferenceLoader", "getProfessorReferenceById"}
    )
    Course fromPutDTO(CoursePutDTO dto);

    List<Course> fromPutDTO(List<CoursePutDTO> dto);
    Set<Course> fromPutDTO(Set<CoursePutDTO> dto);
}
