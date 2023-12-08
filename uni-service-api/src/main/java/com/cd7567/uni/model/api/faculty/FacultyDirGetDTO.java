package com.cd7567.uni.model.api.faculty;

import com.cd7567.uni.model.api.direction.DirectionBriefGetDTO;
import com.cd7567.uni.model.api.professor.ProfessorBriefGetDTO;

import java.util.Set;

public class FacultyDirGetDTO {
    private Long id;
    private String name;
    private ProfessorBriefGetDTO director;
    private Set<DirectionBriefGetDTO> directions;

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

    public Set<DirectionBriefGetDTO> getDirections() {
        return directions;
    }

    public void setDirections(Set<DirectionBriefGetDTO> directions) {
        this.directions = directions;
    }
}
