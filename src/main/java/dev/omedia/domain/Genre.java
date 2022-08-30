package dev.omedia.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Genre implements Serializable {

    private static final long serialVersionUID = 1234567L;

    @Id
    @Column(name = "genre_id")
    @EqualsAndHashCode.Include
    private long id;

    @Column(name = "name", length = 128, nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

}
