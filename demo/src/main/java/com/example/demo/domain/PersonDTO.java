package com.example.demo.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDTO {
    private String name;
    private Set<String> liGroup = new HashSet<>();;
    
    public PersonDTO(String Title, List<Group> names){
        this.name = Title;
        for(Group grupo: names){
            liGroup.add(grupo.getName());
        }
    }

    public String get_title(){
        return name;
    }
    public Set<String> get_liGroup(){
        return liGroup;
    }

}