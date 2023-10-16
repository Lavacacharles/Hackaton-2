package com.example.demo.domain;

// import com.example.demo.infraestructure.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Infraestructure.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson;
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