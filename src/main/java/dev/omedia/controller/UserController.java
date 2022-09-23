package dev.omedia.controller;

import dev.omedia.domain.User;
import dev.omedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public Iterable<User> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{uuid}")
    public User getUserById(@PathVariable String uuid) {
        return userService.getUser(uuid);
    }
}
