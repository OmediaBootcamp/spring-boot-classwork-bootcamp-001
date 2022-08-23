package dev.omedia.controller;


import dev.omedia.domain.Genre;
import dev.omedia.service.GenreService;
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
@RequestMapping("genres")
//TODO add descriptions
//TODO add logs
//TODO add exceptions
public class GenreController {

    private final GenreService service;

    @Autowired
    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Genre> getGenres() {
        return service.getAll();
    }

    // fixme
    @GetMapping("{id}")
    public Genre getGenreById(@PathVariable long id) {
        return service.getById(id).orElseThrow(RuntimeException::new);
    }


    @PutMapping("{id}")
    public Genre update(@PathVariable long id, @RequestBody Genre genre) {
        genre.setId(id);
        return service.update(genre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre create(@RequestBody Genre genre) {
        return service.create(genre);
    }


}
