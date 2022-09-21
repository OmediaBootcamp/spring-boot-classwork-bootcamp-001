package dev.omedia.service;

import dev.omedia.models.User;
import dev.omedia.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        createUser(new User(new Random().nextLong(), UUID.randomUUID().toString()));
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User userFromDb = getUser(id);
        userFromDb.setName(user.getName());
        return userRepository.save(userFromDb);
    }
}
