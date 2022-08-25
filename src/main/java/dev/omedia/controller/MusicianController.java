package dev.omedia.controller;


import dev.omedia.domain.music.Musician;
import dev.omedia.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("musicians")
//TODO add descriptions
//TODO add logs
//TODO add exceptions
public class MusicianController {

    private final MusicianService service;

    @Autowired
    public MusicianController(MusicianService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Musician> getMusicians() {
        return service.getAll();
    }

    // fixme
    @GetMapping("{id}")
    public Musician getMusicianById(@PathVariable long id) {
        return service.getById(id).orElseThrow(RuntimeException::new);
    }


    @PutMapping("{id}")
    public Musician update(@PathVariable long id, @RequestBody Musician musician) {
        musician.setId(id);
        return service.update(musician);
    }

    @PutMapping()
    public void update() {
        service.update();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Musician create(@RequestBody Musician musician) {
        return service.create(musician);
    }


}
