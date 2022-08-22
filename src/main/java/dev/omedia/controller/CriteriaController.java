package dev.omedia.controller;

import dev.omedia.service.UserServiceEM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("criteria")
public class CriteriaController {

    private final UserServiceEM service;

    public CriteriaController(UserServiceEM service) {
        this.service = service;
    }

    @GetMapping
    public Object get() {
        return service.returnUsers();
    }
}
