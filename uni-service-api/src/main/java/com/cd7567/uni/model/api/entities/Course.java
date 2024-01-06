package com.cd7567.uni.model.api.entities;

public class Course {
    private Long id;
    private String name;
    private Person chief;

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

    public Person getChief() {
        return chief;
    }

    public void setChief(Person chief) {
        this.chief = chief;
    }
}
