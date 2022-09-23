package dev.omedia.repository;

import dev.omedia.domain.Car;
import dev.omedia.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer > {
}
