package dev.omedia.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "musicians")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Musician implements Serializable {
    @Id
    @Column(name = "musician_id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musician_id_gen")
    @SequenceGenerator(name = "musician_id_gen", sequenceName = "musician_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "name", updatable = false)
    private String fullName;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "musician_genre_map",
            joinColumns = @JoinColumn(name = "musician_id", referencedColumnName = "musician_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    )
    private Set<Genre> genres;

    @JsonIgnore
    @OneToMany(mappedBy = "musician")
    transient private Set<Song> songs;
}
