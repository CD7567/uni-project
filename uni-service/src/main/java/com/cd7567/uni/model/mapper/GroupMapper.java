package com.cd7567.uni.model.mapper;

import com.cd7567.uni.model.Group;
import com.cd7567.uni.model.api.group.GroupBriefGetDTO;
import com.cd7567.uni.model.api.group.GroupPutDTO;
import com.cd7567.uni.model.api.group.GroupStudentGetDTO;
import com.cd7567.uni.repository.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = {
                StudentMapper.class,
                ReferenceLoader.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE
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
