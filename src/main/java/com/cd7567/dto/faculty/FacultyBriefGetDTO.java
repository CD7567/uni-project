package com.cd7567.dto.faculty;

import com.cd7567.dto.professor.ProfessorBriefGetDTO;

public class FacultyBriefGetDTO {
    private Long id;
    private String name;
    private ProfessorBriefGetDTO director;

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
}
