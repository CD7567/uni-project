package com.cd7567.uni.repository;

import com.cd7567.uni.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepo implements PanacheRepository<Person> {
}
