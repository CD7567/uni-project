package com.cd7567.uni.model.api.group;


import com.cd7567.uni.model.api.student.StudentBriefGetDTO;

import java.util.Set;

public class GroupStudentGetDTO {
    private Long id;
    private String number;
    private Set<StudentBriefGetDTO> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<StudentBriefGetDTO> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentBriefGetDTO> students) {
        this.students = students;
    }
}
