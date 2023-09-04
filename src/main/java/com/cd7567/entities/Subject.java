package com.cd7567.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SUBJECT")
public class Subject {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_id_generator"
    )
    @SequenceGenerator(
            name = "subject_id_generator",
            sequenceName = "SUBJECT_ID",
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
            name = "TERM",
            nullable = false
    )
    private Integer term;

    @Column(
            name = "HOURS",
            nullable = false
    )
    private Integer hours;

    @Column(
            name = "TYPE",
            nullable = false,
            length = 16
    )
    @Enumerated(EnumType.STRING)
    private SubjectType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @Column(
            name = "MARK_WAY",
            length = 16
    )
    @Enumerated(EnumType.STRING)
    private MarkWay markWay;

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "seminars"
    )
    private Set<Professor> seminarists = new HashSet<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            mappedBy = "lectures"
    )
    private Set<Professor> lecturers = new HashSet<>();

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

    public SubjectType getType() {
        return type;
    }

    public void setType(SubjectType type) {
        this.type = type;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public MarkWay getMarkWay() {
        return markWay;
    }

    public void setMarkWay(MarkWay markWay) {
        this.markWay = markWay;
    }

    public Set<Professor> getSeminarists() {
        return seminarists;
    }

    public void setSeminarists(Set<Professor> seminarists) {
        this.seminarists = seminarists;
    }

    public Set<Professor> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Professor> lecturers) {
        this.lecturers = lecturers;
    }

    public enum SubjectType {
        OBLIGATORY,
        EXTRA
    }

    public enum MarkWay {
        EXAM,
        RATING
    }
}
