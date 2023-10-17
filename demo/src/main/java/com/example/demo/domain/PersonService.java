package com.example.demo.domain;

// import com.example.demo.infraestructure.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Infraestructure.PersonRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDTO> getAllPersons() {
        List <Person> personas = personRepository.findAll();
        List<PersonDTO> outpersonas = new ArrayList<>();
        for(Person persona: personas){
            outpersonas.add(new PersonDTO(persona.getName(), persona.getGroups()));
        }
        return outpersonas;
    }

    public PersonDTO getPerson(Long id) {
        Person optionalPerson = personRepository.findById(id).get();
        PersonDTO outPerson = new PersonDTO(optionalPerson.getName(), optionalPerson.getGroups());
        return outPerson;
    }

    public Person savePerson( Person person) {
        return personRepository.save(person);
    }
    
    public PersonDTO getGroupsByPerson(Long id) {
        Person opPer = personRepository.findById(id).get();
        PersonDTO outPer = new PersonDTO(opPer.getName(), opPer.getGroups());
        return outPer;
    }



}