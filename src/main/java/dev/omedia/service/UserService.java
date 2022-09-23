package dev.omedia.service;

import dev.omedia.domain.User;
import dev.omedia.messaging.KafkaPureProducer;
import dev.omedia.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final KafkaPureProducer kafkaPureProducer;

    public UserService(UserRepository userRepository, KafkaPureProducer kafkaPureProducer) {
        this.userRepository = userRepository;
        this.kafkaPureProducer = kafkaPureProducer;
    }

    public User createUser(User user) {
        kafkaPureProducer.produceUser(user);
        return userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
