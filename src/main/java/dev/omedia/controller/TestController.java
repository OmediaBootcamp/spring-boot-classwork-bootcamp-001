package dev.omedia.controller;

import dev.omedia.client.TestClient;
import dev.omedia.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TestController {
    private final TestClient testClient;

    @Autowired
    public TestController(@Qualifier("dev.omedia.client.TestClient") TestClient testClient) {
        this.testClient = testClient;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return testClient.getPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable("id") Long id) {
        return testClient.getPost(id);
    }
}
