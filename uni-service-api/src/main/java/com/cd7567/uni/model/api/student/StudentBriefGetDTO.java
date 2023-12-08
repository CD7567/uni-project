package com.cd7567.uni.model.api.student;

public class StudentBriefGetDTO {
    private Long id;
    private String name;

    public StudentBriefGetDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentBriefGetDTO() {
    }

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
}
