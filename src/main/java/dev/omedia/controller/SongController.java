package dev.omedia.controller;


import dev.omedia.domain.music.Song;
import dev.omedia.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("songs")
//TODO add descriptions
//TODO add logs
//TODO add exceptions
public class SongController {

    private final SongService service;

    @Autowired
    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Song> getSongs(@RequestParam(name = "mgid", required = false, defaultValue = "0") long genreId) {
        return genreId == 0 ? service.getAll() : service.getByMusicianGenreId(genreId);
    }

    // fixme
    @GetMapping("{id}")
    public Song getSongById(@PathVariable long id) {
        return service.getById(id).orElseThrow(RuntimeException::new);
    }


    @PutMapping("{id}")
    public Song update(@PathVariable long id, @RequestBody Song song) {
        song.setId(id);
        return service.update(song);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song create(@RequestBody Song song) {
        return service.create(song);
    }


}
