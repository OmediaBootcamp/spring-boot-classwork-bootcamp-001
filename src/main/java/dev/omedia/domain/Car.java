package dev.omedia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @SequenceGenerator(name = "car_id_gen", sequenceName = "car_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq")
    @EqualsAndHashCode.Exclude
    private Integer id;
    private String uuid = UUID.randomUUID().toString();
    private String model;
    private int year;

    public Car(String uuid, String model, int year) {
        this.uuid = uuid;
        this.model = model;
        this.year = year;
    }

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
}
