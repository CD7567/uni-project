package com.cd7567.dto.student;

import com.cd7567.dto.scoreboard.ScoreBriefGetDTO;

import java.util.Set;

public class StudentMarkGetDTO {
    private Long id;
    private String name;
    private Set<ScoreBriefGetDTO> marks;

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

    public Set<ScoreBriefGetDTO> getMarks() {
        return marks;
    }

    public void setMarks(Set<ScoreBriefGetDTO> marks) {
        this.marks = marks;
    }
}
