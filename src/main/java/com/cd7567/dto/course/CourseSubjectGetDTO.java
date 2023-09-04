package com.cd7567.dto.course;

import com.cd7567.dto.subject.SubjectBriefGetDTO;

import java.util.Set;

public class CourseSubjectGetDTO {
    private Long id;
    private String name;
    private Set<SubjectBriefGetDTO> subjects;

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

    public Set<SubjectBriefGetDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectBriefGetDTO> subjects) {
        this.subjects = subjects;
    }
}
