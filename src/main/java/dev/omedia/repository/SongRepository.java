package dev.omedia.repository;

import dev.omedia.domain.music.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    Iterable<Song> findSongByMusicianId(long id);

    Iterable<Song> findSongByMusician_fullName(String fullName);


    /*
SELECT s
FROM music.songs s
    LEFT JOIN music.musicians m ON m.musician_id = s.musician_id
    LEFT JOIN music.musician_genre_map mgm ON m.musician_id = mgm.musician_id
WHERE mgm.genre_id in (?)
     */
    @Query("from Song s join s.musician m join m.genres g where g.id in(:gid)")
    Iterable<Song> findSongByMusicianGenresIdIn(@Param("gid") Iterable<Long> genreIds);

}
