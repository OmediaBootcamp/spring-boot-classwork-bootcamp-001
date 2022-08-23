package dev.omedia.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Genre {

    @Id
    @Column(name = "genre_id")
    @EqualsAndHashCode.Include
    private long id;

    @Column(name = "name", length = 128, nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

}
