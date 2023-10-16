package com.example.demo.domain;

import java.util.List;
import java.util.Set;

public class PersonDTO {
    private String name;
    private List<String> liGroup;
    
    public PersonDTO(String Title, Set<Group> names){
        this.name = Title;
        for(Group grupo: names){
            liGroup.add(grupo.getName());
        }
    }

    public String get_title(){
        return name;
    }
    public List<String> liGroup(){
        return liGroup;
    }

}