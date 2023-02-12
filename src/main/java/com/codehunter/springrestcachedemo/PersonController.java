package com.codehunter.springrestcachedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonDAORepository personDAORepository;

    public PersonController(PersonDAORepository personDAORepository) {
        this.personDAORepository = personDAORepository;
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personDAORepository.findAll()
                .stream()
                .map(PersonController::convertToPersonDomain)
                .toList();
    }

    private static Person convertToPersonDomain(PersonDAO personDAO) {
        return new Person(personDAO.getId(), personDAO.getName(), personDAO.getAge());
    }

    @PostMapping
    public String createPerson(@RequestBody Person person) {
        PersonDAO personDAO = new PersonDAO();
        personDAO.setAge(person.age());
        personDAO.setName(person.name());
        personDAORepository.save(personDAO);
        return "Person created!";
    }

    @GetMapping(path = "/{id}")
    public Person getById(@PathVariable Long id) {
        return personDAORepository.findById(id).map(PersonController::convertToPersonDomain).orElseThrow();
    }
}
