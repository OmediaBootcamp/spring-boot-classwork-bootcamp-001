package dev.omedia.service;

import dev.omedia.domain.Musician;
import dev.omedia.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicianService {
    private final MusicianRepository repo;

    @Autowired
    public MusicianService(MusicianRepository repo) {
        this.repo = repo;
    }

    public Iterable<Musician> getAll() {
        return repo.findAll();
    }

    public Optional<Musician> getById(final long id) {
        return repo.findById(id);
    }

    public Musician update(Musician musician) {
        // TODO throw Exception if doesn't exist;
        repo.existsById(musician.getId());
        return repo.save(musician);
    }


    public Musician create(Musician musician) {
        // TODO throw Exception if exists;
        repo.existsById(musician.getId());
        return repo.save(musician);
    }
}
