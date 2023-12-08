package com.cd7567.uni.model.api.course;

import java.util.Set;

public class CoursePutDTO {
    private Long id;
    private String name;
    private Long directionId;
    private Set<Long> subjectIds;
    private Long chiefId;

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

    public Long getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    public Set<Long> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(Set<Long> subjectIds) {
        this.subjectIds = subjectIds;
    }

    public Long getChiefId() {
        return chiefId;
    }

    public void setChiefId(Long chiefId) {
        this.chiefId = chiefId;
    }
}
