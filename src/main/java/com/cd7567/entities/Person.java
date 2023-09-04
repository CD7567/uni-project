package com.cd7567.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PERSON")
@DiscriminatorColumn(
        name = "PER_DISC",
        length = 16
)
public class Person {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_id_generator"
    )
    @SequenceGenerator(
            name = "person_id_generator",
            sequenceName = "PERSON_ID",
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

    @Column(
            name = "PER_DISC",
            updatable = false,
            insertable = false
    )
    private String type;

    @Column(
            name = "FIRST_NAME",
            nullable = false,
            length = 128
    )
    protected String firstName;

    @Column(
            name = "LAST_NAME",
            nullable = false,
            length = 128
    )
    protected String lastName;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
