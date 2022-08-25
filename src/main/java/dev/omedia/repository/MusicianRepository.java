package dev.omedia.repository;

import dev.omedia.domain.music.Musician;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface MusicianRepository extends CrudRepository<Musician, Long> {

    @Transactional
    @Modifying
    @Query("update Musician m set m.fullName=:defaultName where m.fullName is null ")
    void updateNullNames(String defaultName);
}
