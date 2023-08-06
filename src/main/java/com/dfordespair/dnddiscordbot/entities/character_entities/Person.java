package com.dfordespair.dnddiscordbot.entities.character_entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class Person {
    @Id
    private Long id;
    @Column(
            nullable = false,
            name = "first_name"
    )
    private String firstName;
    @Column(
            name = "last_name"
    )
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Person person = (Person)o;
            return Objects.equals(this.firstName, person.firstName) && Objects.equals(this.lastName, person.lastName) && Objects.equals(this.id, person.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.firstName, this.lastName, this.id});
    }

    public String toString() {
        return "Person{firstName='" + this.firstName + "', lastName='" + this.lastName + "', id=" + this.id + "}";
    }
}
