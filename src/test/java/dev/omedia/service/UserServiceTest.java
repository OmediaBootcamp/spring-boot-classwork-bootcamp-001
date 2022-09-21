package dev.omedia.service;

import dev.omedia.models.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void getUser() {
    }

    @Test
    void createUser() {
        userService.createUser(new User(14L,"GIORGI"));
    }

    @Test
    void updateUser() {

    }
}