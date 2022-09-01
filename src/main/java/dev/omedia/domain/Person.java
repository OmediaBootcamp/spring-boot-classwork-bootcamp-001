package dev.omedia.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Person extends Owner {

    @Digits(integer = 11, fraction = 0)
    @Column(nullable = false, length = 11)
    private String personalNo;

    @Past
    private LocalDate birthDate;

    public Person(long id, @NotBlank @Length(max = 128) String name, String personalNo, LocalDate birthDate) {
        super(id, name);
        this.personalNo = personalNo;
        this.birthDate = birthDate;
    }
}
