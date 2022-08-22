package dev.omedia.repository;


import dev.omedia.dto.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepo extends Repository<User, Long> {

    <S extends User> S save(User entity);

    Optional<User> findById(Long id);

    Iterable<User> findAll();

    Iterable<User> getUserByName(String name);

    Iterable<User> findByIdGreaterThan(long l);

}
