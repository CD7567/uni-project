package com.cd7567.uni.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FACULTY")
public class Faculty {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "faculty_id_generator"
    )
    @SequenceGenerator(
            name = "faculty_id_generator",
            sequenceName = "FACULTY_ID",
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
    @JoinColumn(name = "DIRECTOR_ID")
    private Professor director;

    @OneToMany(
            targetEntity = Direction.class,
            fetch = FetchType.LAZY,
            mappedBy = "faculty",
            orphanRemoval = true
    )
    private Set<Direction> directions = new HashSet<>();

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

    public Professor getDirector() {
        return director;
    }

    public void setDirector(Professor director) {
        this.director = director;
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public void setDirections(Set<Direction> directions) {
        this.directions = directions;
    }
}
