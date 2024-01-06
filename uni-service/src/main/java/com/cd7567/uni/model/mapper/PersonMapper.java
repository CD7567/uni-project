package com.cd7567.uni.model.mapper;

import com.cd7567.uni.model.Person;
import com.cd7567.uni.model.api.person.PersonBriefGetDTO;
import com.cd7567.uni.model.api.person.PersonInfoGetDTO;
import com.cd7567.uni.repository.ReferenceLoader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "jakarta",
        uses = ReferenceLoader.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PersonMapper {
    @Mapping(target = "id", source = "person.id")
    @Mapping(target = "type", source = "person.type")
    @Mapping(target = "firstName", source = "person.firstName")
    @Mapping(target = "lastName", source = "person.lastName")
    com.cd7567.uni.model.api.entities.Person toDTO(Person person);

    @Mapping(target = "id", source = "person.id")
    @Mapping(target = "name", expression = "java(person.getFirstName() + ' ' + person.getLastName())")
    @Mapping(target = "type", source = "person.type")
    PersonBriefGetDTO toBriefDTO(Person person);

    List<PersonBriefGetDTO> toBriefDTO(List<Person> people);
    Set<PersonBriefGetDTO> toBriefDTO(Set<Person> people);

    @Mapping(target = "id", source = "person.id")
    @Mapping(target = "firstName", source = "person.firstName")
    @Mapping(target = "lastName", source = "person.lastName")
    @Mapping(target = "type", source = "person.type")
    PersonInfoGetDTO toInfoDTO(Person person);

    List<PersonInfoGetDTO> toInfoDTO(List<Person> people);
    Set<PersonInfoGetDTO> toInfoDTO(Set<Person> people);
}
