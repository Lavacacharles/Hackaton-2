package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class mapper {
    //-----------------------------------------------

    public static GroupResponseDTO groupToGroupResponseDto(Group group) {
        GroupResponseDTO groupResponseDto = new GroupResponseDTO();
        groupResponseDto.setId(group.getId());
        groupResponseDto.setName(group.getName());
        List<String> names = new ArrayList<>();
        List<Person> persons = group.getPersons();
        for (Person person: persons) {
            names.add(person.getName());
        }
        groupResponseDto.setPersonNames(names);
        return groupResponseDto;
    }

    public static List<GroupResponseDTO> groupsToGroupResponseDtos(List<Group> groups){
        List<GroupResponseDTO> groupResponseDtos = new ArrayList<>();
        for (Group group: groups) {
            groupResponseDtos.add(groupToGroupResponseDto(group));
        }
        return groupResponseDtos;
    }


}