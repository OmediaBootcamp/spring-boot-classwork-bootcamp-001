package dev.omedia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.omedia.domain.User;
import dev.omedia.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testcontainers.shaded.com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void createUser() throws Exception {
        User user = new User("1", "01", "ragac", "ragac");
        User user2 = repository.save(user);
        mockMvc.perform(post("/user")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(user)))
                        .andExpect(status().isOk());
        Assertions.assertEquals(user,user2);
    }

    @Test
    void getUser() throws Exception {
        //Given
        User user = new User("1", "01", "ragac", "ragac");
        User user2 = new User("2", "01", "vigac", "ragac");
        List<User> users = List.of(user, user2);
        repository.saveAll(users);
        //Then
        mockMvc.perform(get("/user"))
                .andExpect(content().json(mapper.writeValueAsString(users)));
    }

    @Test
    void getUserWithResultAssertion() throws Exception {
        User user = new User("1", "01", "ragac", "ragac");
        User user2 = new User("2", "01", "vigac", "ragac");
        List<User> users = List.of(user, user2);
        repository.saveAll(users);
        RequestBuilder request = get("/user");
        MvcResult result = mockMvc.perform(request).andReturn();
        List<User> list = (List<User>)mapper.readValue(result.getResponse().getContentAsString(), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        assertEquals(users, list);
    }

    @Test
    void getUserById() throws Exception {
        User user = new User("1", "01", "ragac", "ragac");
        repository.save(user);
        mockMvc.perform(get("/user/1"))
                .andExpect(content().json(mapper.writeValueAsString(user)));
    }

}