package dev.omedia.service;

import dev.omedia.domain.Song;
import dev.omedia.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {
    private final SongRepository repo;

    @Autowired
    public SongService(SongRepository repo) {
        this.repo = repo;
    }

    public Iterable<Song> getAll() {
        return repo.findAll();
    }

    public Optional<Song> getById(final long id) {
        return repo.findById(id);
    }

    public Song update(Song song) {
        // TODO throw Exception if doesn't exist;
        repo.existsById(song.getId());
        return repo.save(song);
    }


    public Song create(Song song) {
        // TODO throw Exception if exists;
        repo.existsById(song.getId());
        return repo.save(song);
    }
}
