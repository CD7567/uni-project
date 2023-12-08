package com.cd7567.uni.model.api.subject;

public class SubjectInfoGetDTO {
    private Long id;
    private String name;
    private Integer term;
    private Integer hours;
    private String type;
    private String markWay;

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

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMarkWay() {
        return markWay;
    }

    public void setMarkWay(String markWay) {
        this.markWay = markWay;
    }
}
