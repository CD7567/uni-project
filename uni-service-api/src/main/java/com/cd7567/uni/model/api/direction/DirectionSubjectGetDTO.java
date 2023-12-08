package com.cd7567.uni.model.api.direction;

import com.cd7567.uni.model.api.course.CourseSubjectGetDTO;

import java.util.Set;

public class DirectionSubjectGetDTO {
    private Long id;
    private String name;
    private Set<CourseSubjectGetDTO> courses;

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

    public Set<CourseSubjectGetDTO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseSubjectGetDTO> courses) {
        this.courses = courses;
    }
}
