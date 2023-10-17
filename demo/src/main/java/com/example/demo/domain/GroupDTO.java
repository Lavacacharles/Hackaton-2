package com.example.demo.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GroupDTO {
    private String name;
    private Set<String> liGroup = new HashSet<>();
    
    public GroupDTO(String Title, List<Person> names){
        this.name = Title;
        for(Person grupo: names){
            liGroup.add(grupo.getName());
        }
    }

    public String get_title(){
        return name;
    }
    public Set<String> liGroup(){
        return liGroup;
    }

}