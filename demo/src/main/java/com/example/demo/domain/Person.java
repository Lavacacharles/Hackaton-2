package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "person_group",    
        joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
        )
    private Set<Group> groups = new HashSet<>();

    Person(){}

    Person(String nombre, Set<Group> grupos){
        this.name = nombre;
        this.groups = grupos;
    }

    public void setName(String nombre){
        this.name = nombre;
    }

    public void setGroups(Set<Group> grupos){
        this.groups = grupos;
    }

    public String getName(){
        return name;
    }

    public Set<Group> getGroups(){
        return groups;
    }    
}
