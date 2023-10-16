package com.example.demo.Infraestructure;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}