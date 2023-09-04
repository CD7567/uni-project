package com.cd7567.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("PROF")
public class Professor extends Person {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "LECTURER_COURSE",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private Set<Subject> lectures = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SEMINARIST_COURSE",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private Set<Subject> seminars = new HashSet<>();

    @Column(name = "POSITION")
    private String position;

    public Set<Subject> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Subject> lectures) {
        this.lectures = lectures;
    }

    public Set<Subject> getSeminars() {
        return seminars;
    }

    public void setSeminars(Set<Subject> seminars) {
        this.seminars = seminars;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
