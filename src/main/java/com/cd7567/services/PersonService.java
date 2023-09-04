package com.cd7567.services;

import com.cd7567.dto.person.PersonBriefGetDTO;
import com.cd7567.dto.person.PersonInfoGetDTO;
import com.cd7567.dto.person.PersonMapper;
import com.cd7567.repositories.PersonRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonMapper personMapper;

    @Inject
    PersonRepo personRepo;

    public List<PersonBriefGetDTO> getPeopleBrief() {
        return personMapper.toBriefDTO(personRepo.listAll());
    }

    public List<PersonInfoGetDTO> getPeopleInfo() {
        return personMapper.toInfoDTO(personRepo.listAll());
    }
}
