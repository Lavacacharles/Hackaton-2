package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private PersonRepository personRepository;

    public GroupService(GroupRepository groupRepository, PersonRepository personRepository) {
        this.groupRepository = groupRepository;
        this.personRepository = personRepository;
    }

    // Crear un nuevo grupo
    @Transactional
    public ResponseEntity<Object> addGroup(Group group)  {

        Group newGroup = new Group();
        newGroup.setName(group.getName());
        List<Group> groupList = new ArrayList<>();
        groupList.add(newGroup);
        for(int i=0; i< group.getPersons().size(); i++){
            //if(!personRepository.findById(group.getPersons().get(i).getId()).isPresent()) {
                Person newPerson = group.getPersons().get(i);
                newPerson.setGroups(groupList);
                Person savedPerson = personRepository.save(newPerson);
                if(! personRepository.findById(savedPerson.getId()).isPresent())
                    return ResponseEntity.unprocessableEntity().body("Group Creation Failed");
            //}
            //else  return   ResponseEntity.unprocessableEntity().body("Person with email Id is already Present");
        }
        return ResponseEntity.ok("Successfully created Group");
    }
}
