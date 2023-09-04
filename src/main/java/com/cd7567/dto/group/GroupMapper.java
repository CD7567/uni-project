package com.cd7567.dto.group;

import com.cd7567.dto.student.StudentMapper;
import com.cd7567.entities.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = StudentMapper.class
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
}
