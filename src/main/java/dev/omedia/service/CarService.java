package dev.omedia.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCursor;
import dev.omedia.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final MongoClient mg;
    private final MongoTemplate mt;
    @Value("${spring.data.mongodb.database}")
    private String dataBaseName;

    @Autowired
    public CarService(MongoClient mg, MongoTemplate mt) {
        this.mg = mg;
        this.mt = mt;
    }


    public Iterable<Car> getAll(){
        final List cars = new ArrayList<>();
        MongoCursor vehicle = mg.getDatabase(dataBaseName).getCollection("vehicle").find().cursor();
        while(vehicle.hasNext()){
            cars.add(vehicle.next());
        }
        return cars;
    }
}
