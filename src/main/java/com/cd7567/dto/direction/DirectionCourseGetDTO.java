package com.cd7567.dto.direction;

import com.cd7567.dto.course.CourseBriefGetDTO;

import java.util.Set;

public class DirectionCourseGetDTO {
    private Long id;
    private String name;
    private Set<CourseBriefGetDTO> courses;

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

    public Set<CourseBriefGetDTO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseBriefGetDTO> courses) {
        this.courses = courses;
    }
}
