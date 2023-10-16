package com.example.demo.domain;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Infraestructure.GroupRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GroupService {

    private final GroupRepository groupRepository;


    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;

    }

    @Transactional
    public GroupResponseDTO addGroup(GroupRequestDTO groupRequestDto) {
        Group group = new Group();
        group.setName(groupRequestDto.getName());

        groupRepository.save(group);
        return mapper.groupToGroupResponseDto(group);
    }

    public List<GroupResponseDTO> getGroups() {
        List<Group> groups = StreamSupport
                .stream(groupRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return mapper.groupsToGroupResponseDtos(groups);
    }

    public GroupResponseDTO getGroupById(Long groupId) {
        return mapper.groupToGroupResponseDto(getGroup(groupId));
    }

    public Group getGroup(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() ->
                new IllegalArgumentException(
                        "group with id: " + groupId + " could not be found"));
        return group;
    }


}