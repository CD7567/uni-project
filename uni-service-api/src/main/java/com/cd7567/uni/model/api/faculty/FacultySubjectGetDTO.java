package com.cd7567.uni.model.api.faculty;

import com.cd7567.uni.model.api.professor.ProfessorBriefGetDTO;
import com.cd7567.uni.model.api.direction.DirectionSubjectGetDTO;

import java.util.Set;

public class FacultySubjectGetDTO {
    private Long id;
    private String name;
    private ProfessorBriefGetDTO director;
    private Set<DirectionSubjectGetDTO> directions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfessorBriefGetDTO getDirector() {
        return director;
    }

    public void setDirector(ProfessorBriefGetDTO director) {
        this.director = director;
    }

    public Set<DirectionSubjectGetDTO> getDirections() {
        return directions;
    }

    public void setDirections(Set<DirectionSubjectGetDTO> directions) {
        this.directions = directions;
    }
}
