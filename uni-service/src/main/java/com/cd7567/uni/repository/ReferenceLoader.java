package com.cd7567.uni.repository;

import com.cd7567.uni.model.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.mapstruct.Named;

@ApplicationScoped
@Named("ReferenceLoader")
public class ReferenceLoader {
    @Inject
    EntityManager entityManager;

    @Named("getCourseReferenceById")
    public Course getCourseReferenceById(Long id) {
        return entityManager.getReference(Course.class, id);
    }

    @Named("getDirectionReferenceById")
    public Direction getDirectionReferenceById(Long id) {
        return entityManager.getReference(Direction.class, id);
    }

    @Named("getFacultyReferenceById")
    public Faculty getFacultyReferenceById(Long id) {
        return entityManager.getReference(Faculty.class, id);
    }

    @Named("getGroupReferenceById")
    public Group getGroupReferenceById(Long id) {
        return entityManager.getReference(Group.class, id);
    }

    @Named("getPersonReferenceById")
    public Person getPersonReferenceById(Long id) {
        return entityManager.getReference(Person.class, id);
    }

    @Named("getProfessorReferenceById")
    public Professor getProfessorReferenceById(Long id) {
        return entityManager.getReference(Professor.class, id);
    }

    @Named("getScoreReferenceById")
    public ScoreBoardRecord getScoreReferenceById(Long id) {
        return entityManager.getReference(ScoreBoardRecord.class, id);
    }

    @Named("getStudentReferenceById")
    public Student getStudentReferenceById(Long id) {
        return entityManager.getReference(Student.class, id);
    }

    @Named("getPlanReferenceById")
    public StudentPlanRecord getPlanReferenceById(Long id) {
        return entityManager.getReference(StudentPlanRecord.class, id);
    }

    @Named("getSubjectReferenceById")
    public Subject getSubjectReferenceById(Long id) {
        return entityManager.getReference(Subject.class, id);
    }
}
