package dev.omedia.repository;


import dev.omedia.dto.User;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Iterable<User> getUserByName(String name);

    Iterable<User> findByIdGreaterThan(long l);

}
