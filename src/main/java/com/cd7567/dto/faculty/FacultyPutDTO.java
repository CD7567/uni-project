package com.cd7567.dto.faculty;

import java.util.Set;

public class FacultyPutDTO {
    private Long id;
    private String name;
    private Long directorId;
    private Set<Long> directionIds;

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

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Set<Long> getDirectionIds() {
        return directionIds;
    }

    public void setDirectionIds(Set<Long> directionIds) {
        this.directionIds = directionIds;
    }
}
