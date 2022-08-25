package dev.omedia.domain.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lyrics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lyrics {

    @Id
    @Column(name = "lyric_id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lyric_id_gen")
    @SequenceGenerator(name = "lyric_id_gen", sequenceName = "lyric_id_seq", allocationSize = 1)
    private long id;

    //    @Lob
    @Column(name = "lyrics", nullable = false, columnDefinition = "text")
    private String text;

    @JsonIgnore
    @OneToOne(mappedBy = "lyrics")
    private Song song;
}
