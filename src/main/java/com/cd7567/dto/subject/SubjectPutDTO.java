package com.cd7567.dto.subject;

import java.util.Set;

public class SubjectPutDTO {
    private Long id;
    private String name;
    private Integer term;
    private Integer hours;
    private String type;
    private Long courseId;
    private String markWay;
    private Set<Long> seminaristIds;
    private Set<Long> lecturerIds;

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getMarkWay() {
        return markWay;
    }

    public void setMarkWay(String markWay) {
        this.markWay = markWay;
    }

    public Set<Long> getSeminaristIds() {
        return seminaristIds;
    }

    public void setSeminaristIds(Set<Long> seminaristIds) {
        this.seminaristIds = seminaristIds;
    }

    public Set<Long> getLecturerIds() {
        return lecturerIds;
    }

    public void setLecturerIds(Set<Long> lecturerIds) {
        this.lecturerIds = lecturerIds;
    }
}
