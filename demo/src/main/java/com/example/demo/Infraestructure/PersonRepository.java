package com.example.demo.Infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
    // List<Person> findByGradesContaining(Grade grade);
}