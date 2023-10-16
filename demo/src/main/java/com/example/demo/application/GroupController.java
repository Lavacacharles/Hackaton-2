package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.GroupRequestDTO;
import com.example.demo.domain.GroupResponseDTO;
import com.example.demo.domain.GroupService;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<GroupResponseDTO> addGroup(
            @RequestBody final GroupRequestDTO groupRequestDto) {
        GroupResponseDTO groupResponseDto = groupService.addGroup(groupRequestDto);
        return new ResponseEntity<>(groupResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> getGroup(@PathVariable final Long id) {
        GroupResponseDTO GroupResponseDto = groupService.getGroupById(id);
        return new ResponseEntity<>(GroupResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponseDTO>> getGroups() {
        List<GroupResponseDTO> GroupResponseDtos = groupService.getGroups();
        return new ResponseEntity<>(GroupResponseDtos, HttpStatus.OK);
    }
}