package com.cd7567.uni.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("STUD")
public class Student extends Person {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToMany(
            fetch = FetchType.LAZY,
            targetEntity = Course.class
    )
    @JoinTable(
            name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private Set<Course> courses = new HashSet<>();

    @OneToMany(
            targetEntity = StudentPlanRecord.class,
            fetch = FetchType.LAZY,
            mappedBy = "student",
            orphanRemoval = true
    )
    private Set<StudentPlanRecord> planItems = new HashSet<>();

    @OneToMany(
            targetEntity = ScoreBoardRecord.class,
            fetch = FetchType.LAZY,
            mappedBy = "student",
            orphanRemoval = true
    )
    private Set<ScoreBoardRecord> marks = new HashSet<>();


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<StudentPlanRecord> getPlanItems() {
        return planItems;
    }

    public void setPlanItems(Set<StudentPlanRecord> planItems) {
        this.planItems = planItems;
    }

    public Set<ScoreBoardRecord> getMarks() {
        return marks;
    }

    public void setMarks(Set<ScoreBoardRecord> marks) {
        this.marks = marks;
    }
}
