package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Person;
import com.example.demo.domain.PersonDTO;
import com.example.demo.domain.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    public ResponseEntity<List<PersonDTO>> persons() {
        List<PersonDTO> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}") //Todas las personas que estan en ese grupo
    public ResponseEntity<PersonDTO> persons(@PathVariable Long id) {
    PersonDTO person = personService.getPerson(id);
    return ResponseEntity.status(HttpStatus.OK).body(person);
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