package com.cd7567.uni.service;

import com.cd7567.uni.model.api.person.PersonBriefGetDTO;
import com.cd7567.uni.model.api.person.PersonInfoGetDTO;
import com.cd7567.uni.model.mapper.PersonMapper;
import com.cd7567.uni.repository.PersonRepo;
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
