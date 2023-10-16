package com.example.demo.domain;

import java.util.List;

public class GroupResponseDTO {
    private Long id;
    private String name;
    private List<String> personNames;

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

    public List<String> getPersonNames() {
        return personNames;
    }

    public void setPersonNames(List<String> personNames) {
        this.personNames = personNames;
    }
}