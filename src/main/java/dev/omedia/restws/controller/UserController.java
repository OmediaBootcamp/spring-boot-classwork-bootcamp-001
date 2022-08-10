package dev.omedia.restws.controller;

import dev.omedia.restws.config.Config;
import dev.omedia.restws.exceptions.UserNotFoundException;
import dev.omedia.restws.model.User;
import dev.omedia.restws.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {
    private final UserService service;
    private final Config config;

    @Autowired
    public UserController(UserService service, Config config) {
        this.service = service;
        this.config = config;
    }

    @GetMapping
    public Collection<User> getUsers(
            @RequestParam(required = false, defaultValue = "${page}", name = "p") int page
            , @RequestParam(required = false, defaultValue = "${pageSize}", name = "s") int pageSize) {
        log.error("page{} pageSize{}",page,pageSize);
        log.error(config.toString());
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

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
