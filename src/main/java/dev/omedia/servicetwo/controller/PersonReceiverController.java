package dev.omedia.servicetwo.controller;

import dev.omedia.serviceone.model.Person;
import dev.omedia.servicetwo.service.PersonReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("personreceivers")
public class PersonReceiverController {
    private final PersonReceiverService service;

    @Autowired
    public PersonReceiverController(PersonReceiverService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Person> getAll() throws URISyntaxException {
        return service.getAll();
    }
}
