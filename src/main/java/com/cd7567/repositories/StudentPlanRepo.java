package com.cd7567.repositories;

import com.cd7567.entities.Group;
import com.cd7567.entities.Student;
import com.cd7567.entities.StudentPlanRecord;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentPlanRepo implements PanacheRepository<StudentPlanRecord> {
    @Transactional
    public Long update(StudentPlanRecord planItem) {
        persist(planItem);
        return planItem.getId();
    }
}
