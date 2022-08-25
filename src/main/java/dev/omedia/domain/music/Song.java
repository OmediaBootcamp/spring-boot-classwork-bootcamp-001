package dev.omedia.domain.music;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Song {
    @Id
    @Column(name = "song_id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_id_gen")
    @SequenceGenerator(name = "song_id_gen", sequenceName = "song_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genres;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "musician_id", nullable = false)
    private Musician musician;

    @JsonIgnore
    @Column(name = "musician_id", insertable = false, updatable = false)
    private long musicianId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lyrics_id", nullable = false)
    private Lyrics lyrics;
}
