package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "GROUPS_TBL")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "groups")
    private List<Person> persons = new ArrayList<>();

    public Group() {

    }

    public Group(String name, List<Person> personas) {
        this.name = name;
        this.persons = personas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}