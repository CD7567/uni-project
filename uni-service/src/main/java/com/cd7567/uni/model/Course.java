package com.cd7567.uni.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_id_generator"
    )
    @SequenceGenerator(
            name = "course_id_generator",
            sequenceName = "COURSE_ID",
            allocationSize = 20
    )
    @Column(
            name = "ID",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Version
    @Column(
            name = "VERSION",
            nullable = false
    )
    private Long version;

    @Column(
            name = "NAME",
            nullable = false,
            length = 128
    )
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIRECTION_ID")
    private Direction direction;

    @OneToMany(
            targetEntity = Subject.class,
            fetch = FetchType.LAZY,
            mappedBy = "course",
            orphanRemoval = true
    )
    private Set<Subject> subjects = new HashSet<>();

    @OneToOne(
            targetEntity = Professor.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CHIEF_ID")
    private Professor chief;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Professor getChief() {
        return chief;
    }

    public void setChief(Professor chief) {
        this.chief = chief;
    }
}
