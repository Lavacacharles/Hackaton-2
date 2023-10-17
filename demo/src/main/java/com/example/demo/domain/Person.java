package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name = "PERSONS_TBL")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "person_group",    
        joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
        )
    private List<Group> groups = new ArrayList<>();

    Person(){}

    Person(String nombre, List<Group> grupos){
        this.name = nombre;
        this.groups = grupos;
    }

    public void setName(String nombre){
        this.name = nombre;
    }

    public void setGroups(List<Group> grupos){
        this.groups = grupos;
    }

    public String getName(){
        return name;
    }

    public List<Group> getGroups(){
        return groups;
    }    
}
