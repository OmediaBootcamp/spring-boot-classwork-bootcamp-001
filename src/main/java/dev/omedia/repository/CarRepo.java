package dev.omedia.repository;

import dev.omedia.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends MongoRepository<Car, String> {

}
