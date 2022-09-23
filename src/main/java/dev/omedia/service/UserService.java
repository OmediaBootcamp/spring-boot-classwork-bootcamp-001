package dev.omedia.service;

import dev.omedia.domain.User;
import dev.omedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import static dev.omedia.service.constant.BindingNames.*;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final StreamBridge bridge;

    @Autowired
    public UserService(UserRepository userRepository, StreamBridge bridge) {
        this.userRepository = userRepository;
        this.bridge = bridge;
    }

    public User createUser(User user) {
        bridge.send(USER_OUT_BINDING,user);
        return userRepository.save(user);
    }

    public User getUser(String uuid) {
        return userRepository.findByUuid(uuid).orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User update(String uuid, User user){
        getUser(uuid);
        user.setUuid(uuid);
        return userRepository.save(user);
    }
}
