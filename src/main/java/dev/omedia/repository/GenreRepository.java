package dev.omedia.repository;

import dev.omedia.domain.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
}
