package com.cd7567.uni.model.api.student;

import java.util.Set;

public class StudentPutDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long groupId;
    private Set<Long> courseIds;
    private Set<Long> studentPlanIds;
    private Set<Long> markIds;

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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Set<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(Set<Long> courseIds) {
        this.courseIds = courseIds;
    }

    public Set<Long> getStudentPlanIds() {
        return studentPlanIds;
    }

    public void setStudentPlanIds(Set<Long> studentPlanIds) {
        this.studentPlanIds = studentPlanIds;
    }

    public Set<Long> getMarkIds() {
        return markIds;
    }

    public void setMarkIds(Set<Long> markIds) {
        this.markIds = markIds;
    }
}
