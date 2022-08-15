package dev.omedia.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "some_schema")
public class User {
    @Id
    @Column(name = "id")
    private long id;


    private String name;
}
