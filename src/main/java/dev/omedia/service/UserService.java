package dev.omedia.service;

import dev.omedia.domain.User;
import dev.omedia.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        //        produce user message / or audit message as you decide
        return userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
