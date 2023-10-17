package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Infraestructure.GroupRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
//Post a grupo
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }
//Get todos
    public List<GroupDTO> getGroups() {
        List <Group> grupos = groupRepository.findAll();
        List<GroupDTO> outGrupos = new ArrayList<>();
        for(Group grupo: grupos){
            outGrupos.add(new GroupDTO(grupo.getName(), grupo.getPersons()));
        }
        return outGrupos;
        
    }
//Get por id
    public GroupDTO getGroupById(Long id) {
        Group perGroup = groupRepository.findById(id).get();
        GroupDTO outGroup = new GroupDTO(perGroup.getName(), perGroup.getPersons());
        return outGroup;      
    }
//Get a grupo por id
//orElseThrow(() -> new IllegalArgumentException("group with id: " + groupId + " could not be found"));
    public GroupDTO getGroup(Long id) {
        Group opGroup = groupRepository.findById(id).get();
        GroupDTO outGroup = new GroupDTO(opGroup.getName(), opGroup.getPersons());
        return outGroup;
    }


}