package dev.omedia.restws.model;

import lombok.*;

import java.time.LocalDate;

//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private long id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final LocalDate registrationDate;
    private final LocalDate birthDate;
}
