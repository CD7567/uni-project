package com.cd7567.dto.professor;

import java.util.Set;

public class ProfessorPutDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<Long> lectSubjectIds;
    private Set<Long> semSubjectIds;
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Long> getLectSubjectIds() {
        return lectSubjectIds;
    }

    public void setLectSubjectIds(Set<Long> lectSubjectIds) {
        this.lectSubjectIds = lectSubjectIds;
    }

    public Set<Long> getSemSubjectIds() {
        return semSubjectIds;
    }

    public void setSemSubjectIds(Set<Long> semSubjectIds) {
        this.semSubjectIds = semSubjectIds;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
