package dev.omedia.controller;

import dev.omedia.entity.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/posts")
public class PostController {
    ArrayList<Post> posts = new ArrayList<>();

    @PostConstruct
    public void setUp() {
        posts.add(new Post(1L, "Desc1"));
        posts.add(new Post(2L, "Desc2"));
    }

    @PreDestroy
    public void cleanUp() {
        posts.clear();
    }

    @GetMapping
    public List<Post> getPosts() {
        return posts;
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable("id") Long id) {
        return posts.stream().filter(it -> Objects.equals(it.getId(), id)).findFirst().orElseThrow(IllegalStateException::new);
    }
}
