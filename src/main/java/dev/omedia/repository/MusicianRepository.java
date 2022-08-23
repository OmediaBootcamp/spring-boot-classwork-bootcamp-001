package dev.omedia.repository;

import dev.omedia.domain.Musician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicianRepository extends CrudRepository<Musician, Long> {
}
