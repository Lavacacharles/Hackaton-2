package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Group;
import com.example.demo.domain.GroupDTO;
import com.example.demo.domain.GroupService;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<String> addGroup(@RequestBody Group group) {
        groupService.addGroup(group);
        return ResponseEntity.status(201).body("Created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getOneGroup(@PathVariable Long id) {
        GroupDTO GroupResponseDto = groupService.getGroupById(id);
        return ResponseEntity.status(HttpStatus.OK).body(GroupResponseDto);
    }
//por si aca 
//return ResponseEntity.status(HttpStatus.OK).body(GroupResponseDtos);
//return new ResponseEntity<>(GroupResponseDtos, HttpStatus.OK);

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        List<GroupDTO> GroupResponseDtos = groupService.getGroups();
        return new ResponseEntity<>(GroupResponseDtos, HttpStatus.OK);
    }
}