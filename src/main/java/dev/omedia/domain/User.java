package dev.omedia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @EqualsAndHashCode.Exclude
    private Integer id;
    private String uuid = UUID.randomUUID().toString();
    private String personalNo;
    private String name;
    private String surname;

    public User(String uuid, String personalNo, String name, String surname) {
        this.uuid = uuid;
        this.personalNo = personalNo;
        this.name = name;
        this.surname = surname;
    }

    public User(String personalNo, String name, String surname) {
        this.personalNo = personalNo;
        this.name = name;
        this.surname = surname;
    }
}
