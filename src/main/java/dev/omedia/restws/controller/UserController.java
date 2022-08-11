package dev.omedia.restws.controller;

import dev.omedia.restws.config.Config;
import dev.omedia.restws.exceptions.UserNotFoundException;
import dev.omedia.restws.model.User;
import dev.omedia.restws.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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

    @Operation(summary = "Get users")
    @ApiResponses(value =
            {@ApiResponse(responseCode = "200", description = "Found users", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",description = "Server error", content = {@Content(mediaType = "application/json")})})
    @GetMapping
    public Collection<User> getUsers(@Min(value = 1,message = "incorrect value") @Parameter(description = "page index")@RequestParam(required = false, defaultValue = "${page}", name = "p") int page,
                                     @Min(30)@Max(500)@Parameter(description = "page size")@RequestParam(required = false, defaultValue = "${pageSize}", name = "s") int pageSize) {
        log.error("page{} pageSize{}", page, pageSize);
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
