package com.cd7567.uni.model.api.structure.getcoursebyid;

import com.cd7567.uni.model.api.entities.Course;

import java.util.List;

public class GetCourseByIdResult {
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
