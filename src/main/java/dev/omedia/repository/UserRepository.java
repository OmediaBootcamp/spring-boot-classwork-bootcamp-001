package dev.omedia.repository;

import dev.omedia.domain.Car;
import dev.omedia.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer > {
    @Query(value = "alter sequence public.user_id_seq restart WITH 1", nativeQuery = true)
    @Modifying
    @Transactional
    void resetId();

    Optional<User> findByUuid(String uuid);
}
