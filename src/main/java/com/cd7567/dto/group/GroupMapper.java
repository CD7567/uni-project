package com.cd7567.dto.group;

import com.cd7567.dto.course.CoursePutDTO;
import com.cd7567.dto.student.StudentMapper;
import com.cd7567.entities.Course;
import com.cd7567.entities.Group;
import com.cd7567.repositories.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = {
                StudentMapper.class,
                ReferenceLoader.class
        }
)
public interface GroupMapper {
    @Mapping(target = "id", source = "group.id")
    @Mapping(target = "number", source = "group.number")
    GroupBriefGetDTO toBriefDTO(Group group);

    List<GroupBriefGetDTO> toBriefDTO(List<Group> groups);
    Set<GroupBriefGetDTO> toBriefDTO(Set<Group> groups);

    @Mapping(target = "id", source = "group.id")
    @Mapping(target = "number", source = "group.number")
    @Mapping(target = "students", source = "group.students")
    GroupStudentGetDTO toStudentDTO(Group group);

    List<GroupStudentGetDTO> toStudentDTO(List<Group> groups);
    Set<GroupStudentGetDTO> toStudentDTO(Set<Group> groups);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "number", source = "dto.number")
    @Mapping(target = "term", source = "dto.term")
    @Mapping(
            target = "direction",
            source = "dto.directionId",
            qualifiedByName = {"ReferenceLoader", "getDirectionReferenceById"}
    )
    @Mapping(
            target = "students",
            source = "dto.studentIds",
            qualifiedByName = {"ReferenceLoader", "getStudentReferenceById"}
    )
    Group fromPutDTO(GroupPutDTO dto);

    List<Group> fromPutDTO(List<GroupPutDTO> dto);
    Set<Group> fromPutDTO(Set<GroupPutDTO> dto);
}
