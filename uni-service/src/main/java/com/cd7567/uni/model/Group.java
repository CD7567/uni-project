package com.cd7567.uni.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STUDYGROUP")
public class Group {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_id_generator"
    )
    @SequenceGenerator(
            name = "group_id_generator",
            sequenceName = "GROUP_ID",
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
            name = "NUMBER",
            nullable = false,
            length = 16
    )
    private String number;

    @Column(
            name = "TERM",
            nullable = false
    )
    private Integer term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIRECTION_ID")
    private Direction direction;

    @OneToMany(
            targetEntity = Student.class,
            fetch = FetchType.LAZY,
            mappedBy = "group"
    )
    private Set<Student> students = new HashSet<>();

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
