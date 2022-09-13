package dev.omedia.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "vehicle")
public class Car {
    @MongoId
    private String id;
    private String brand;
    private LocalDateTime saleDate;
}
