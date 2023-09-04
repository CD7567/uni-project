package com.cd7567.dto.subject;

import com.cd7567.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta"
)
public interface SubjectMapper {
    @Mapping(target = "id", source = "subject.id")
    @Mapping(target = "name", source = "subject.name")
    SubjectBriefGetDTO toBriefDTO(Subject subject);

    List<SubjectBriefGetDTO> toBriefDTO(List<Subject> subjects);
    Set<SubjectBriefGetDTO> toBriefDTO(Set<Subject> subjects);

    @Mapping(target = "id", source = "subject.id")
    @Mapping(target = "name", source = "subject.name")
    @Mapping(target = "term", source = "subject.term")
    @Mapping(target = "hours", source = "subject.hours")
    @Mapping(target = "type", source = "subject.type")
    @Mapping(target = "markWay", source = "subject.markWay")
    SubjectInfoGetDTO toInfoDTO(Subject subject);

    List<SubjectInfoGetDTO> toInfoDTO(List<Subject> subjects);
    Set<SubjectInfoGetDTO> toInfoDTO(Set<Subject> subjects);
}
