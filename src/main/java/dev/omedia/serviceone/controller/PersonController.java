package dev.omedia.serviceone.controller;

import dev.omedia.serviceone.model.Person;
import dev.omedia.serviceone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Person> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Person person) {
        service.add(person);
    }
}
