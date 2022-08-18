package dev.omedia.controller;

import dev.omedia.dto.User;
import dev.omedia.exceptions.UserNotFoundException;
import dev.omedia.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    @Operation(summary = "Get user by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found users", content = {@Content(mediaType = "application/json")}), @ApiResponse(responseCode = "404", description = "User not found", content = {@Content(mediaType = "application/json")})})
    public User getUser(@PathVariable final long id) {
        return service.getUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping
    @Operation(summary = "Get users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found users", content = {@Content(mediaType = "application/json")}), @ApiResponse(responseCode = "500", description = "Server error", content = {@Content(mediaType = "application/json")})})
    public Iterable<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create user")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "User created", content = {@Content(mediaType = "application/json")}), @ApiResponse(responseCode = "500", description = "Server error", content = {@Content(mediaType = "application/json")})})
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }

    @PutMapping("{id}")
    @Operation(summary = "update user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User updated"), @ApiResponse(responseCode = "500", description = "Server error")})
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }
}
