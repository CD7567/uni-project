package com.cd7567.uni.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DIRECTION")
public class Direction {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "direction_id_generator"
    )
    @SequenceGenerator(
            name = "direction_id_generator",
            sequenceName = "DIRECTION_ID",
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

    @Column(
            name = "NUMBER",
            nullable = false,
            length = 16
    )
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;

    @OneToMany(
            targetEntity = Group.class,
            fetch = FetchType.LAZY,
            mappedBy = "direction",
            orphanRemoval = true
    )
    private Set<Group> groups = new HashSet<>();

    @OneToMany(
            targetEntity = Course.class,
            fetch = FetchType.LAZY,
            mappedBy = "direction",
            orphanRemoval = true
    )
    private Set<Course> courses = new HashSet<>();

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}