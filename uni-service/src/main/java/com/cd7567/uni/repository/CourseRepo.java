package com.cd7567.uni.repository;

import com.cd7567.uni.model.Course;
import com.cd7567.uni.model.Course_;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CourseRepo implements PanacheRepository<Course> {

    @Transactional
    public List<Course> getByIds(List<Long> ids) {
        EntityManager manager = getEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);

        query.select(root).where(builder.in(root.get(Course_.ID)).value(ids));

        return manager.createQuery(query).getResultList();
    }

    @Transactional
    public Long update(Course course) {
        persist(course);
        return course.getId();
    }
}
