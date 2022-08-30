package dev.omedia.service;

import dev.omedia.domain.Genre;
import dev.omedia.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository repo;
    
    @Autowired
    public GenreService(GenreRepository repo) {
        this.repo = repo;
    }

    @Cacheable("genres")
    public Iterable<Genre> getAll() {
        return repo.findAll();
    }

    public Optional<Genre> getById(final long id) {
        return repo.findById(id);
    }

    public Genre update(Genre genre) {
        // TODO throw Exception if doesn't exist;
        repo.existsById(genre.getId());
        return repo.save(genre);
    }


    public Genre create(Genre genre) {
        // TODO throw Exception if exists;
        repo.existsById(genre.getId());
        return repo.save(genre);
    }
}
