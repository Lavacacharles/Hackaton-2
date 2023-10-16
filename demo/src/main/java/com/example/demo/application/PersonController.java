package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonDTO;
import com.example.demo.domain.PersonService;

// import com.example.demo.domain.Grade;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    public ResponseEntity<List<Person>> persons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}") //Todas las personas que estan en ese grupo
    public ResponseEntity<Person> persons(@PathVariable Long id) {
    Optional<Person> person = personService.getPerson(id);
    return ResponseEntity.status(HttpStatus.OK).body(person.get());
    }  

    @GetMapping("/groups/{id}") //Todos los grupos en los que esta esa persona
    public ResponseEntity<PersonDTO> person_s(@PathVariable Long id) {
    PersonDTO person = personService.getGroupsByPerson(id);
    return ResponseEntity.status(HttpStatus.OK).body(person);
    }  

    @PostMapping
    public ResponseEntity<String> person(@RequestBody Person person) {
        personService.savePerson(person);
        
        return ResponseEntity.status(201).body("Created");
    }


    

}