package dev.omedia.restws.controller;

import dev.omedia.restws.exceptions.UserNotFoundException;
import dev.omedia.restws.model.User;
import dev.omedia.restws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("{identifier}")
    public User getUser(@PathVariable(name = "identifier") long id) {
        Optional<User> userOptional = service.getUser(id);
        /*if (userOptional.isPresent()) {
            return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        return userOptional.orElseThrow(UserNotFoundException::new);
        return userOptional.get();*/

        return userOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found with id " + id));
    }

    @DeleteMapping("{id}")
    public User removeUser(@PathVariable long id) {
        return service.removeUser(id).orElseThrow(UserNotFoundException::new);
    }

    @PostMapping
    public boolean addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PutMapping("{id}")
    public boolean updateUser(@PathVariable long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }
}
