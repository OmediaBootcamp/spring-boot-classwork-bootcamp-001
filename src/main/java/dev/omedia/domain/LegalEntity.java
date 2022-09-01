package dev.omedia.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class LegalEntity extends Owner {

    @Pattern(regexp = "[0-9]{9}")// we can use @Digits(integer = 9, fraction = 0)
    @Column(nullable = false, length = 9)
    private String entityNo;

    private String industry;

    public LegalEntity(long id, @NotBlank @Length(max = 128) String name, String entityNo, String industry) {
        super(id, name);
        this.entityNo = entityNo;
        this.industry = industry;
    }
}
