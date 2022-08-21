package dev.omedia.service;

import dev.omedia.dto.User;
import dev.omedia.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> getUserById(long id) {
        return userRepo.findById(id);
    }


    public Iterable<User> getUserByName(String name) {
        return userRepo.getUserByName(name);
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public User updateUser(long id, User user) {
        user.setId(id);
        return userRepo.save(user);
    }

}
