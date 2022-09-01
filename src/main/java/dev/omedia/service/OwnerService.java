package dev.omedia.service;

import dev.omedia.domain.Owner;
import dev.omedia.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerRepository repo;

    @Autowired
    public OwnerService(OwnerRepository repo) {
        this.repo = repo;
    }

    public Iterable<Owner> getAll() {
        return repo.findAll();
    }

    public Optional<Owner> getById(final long id) {
        return repo.findById(id);
    }

    public Owner update(Owner genre) {
        // TODO throw Exception if doesn't exist;
        repo.existsById(genre.getId());
        return repo.save(genre);
    }


    public Owner create(Owner genre) {
        // TODO throw Exception if exists;
        repo.existsById(genre.getId());
        return repo.save(genre);
    }
}
