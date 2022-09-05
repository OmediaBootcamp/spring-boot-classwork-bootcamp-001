package dev.omedia.serviceone.service;

import dev.omedia.serviceone.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonService {
    ArrayList<Person> persons = new ArrayList<>();

    public Iterable<Person> getAll() {
        return persons;
    }

    public Optional<Person> getById(final Long id) {
        return persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void add(Person person) {
        persons.add(person);
    }
}
