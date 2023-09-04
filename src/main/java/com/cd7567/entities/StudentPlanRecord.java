package com.cd7567.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT_STUDY_PLAN")
public class StudentPlanRecord {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "study_plan_id_generator"
    )
    @SequenceGenerator(
            name = "person_id_generator",
            sequenceName = "STUDY_PLAN_ID",
            allocationSize = 20
    )
    @Column(
            name = "ID",
            updatable = false,
            nullable = false
    )
    protected Long id;

    @Version
    @Column(
            name = "VERSION",
            nullable = false
    )
    protected Long version;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Professor.class
    )
    @JoinColumn(name = "LECTURER_ID")
    private Professor lecturer;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Professor.class
    )
    @JoinColumn(name = "SEMINARIST_ID")
    private Professor seminarist;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Student.class
    )
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Subject.class
    )
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

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

    public Professor getLecturer() {
        return lecturer;
    }

    public void setLecturer(Professor lecturer) {
        this.lecturer = lecturer;
    }

    public Professor getSeminarist() {
        return seminarist;
    }

    public void setSeminarist(Professor seminarist) {
        this.seminarist = seminarist;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
