package dev.omedia;

import dev.omedia.models.Car;
import dev.omedia.service.Calculation;
import dev.omedia.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestClass {

    @Autowired
    private CarService carService;

    @Test
    public void test() {
        Double expected = 5.;
        Double actual = Calculation.divide(10, 2.);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void assertNotNullAndNonNull() {
        Car bmwCar = carService.createCar(new Car(20, "BMW"));
        Car nullCar = carService.createCar(null);
        Assertions.assertNotNull(bmwCar);
        Assertions.assertNull(nullCar);
        Assertions.assertNotEquals(bmwCar, nullCar);

        org.assertj.core.api.Assertions.assertThat(bmwCar).isNotNull();
        org.assertj.core.api.Assertions.assertThat(nullCar).isNull();
        org.assertj.core.api.Assertions.assertThat(bmwCar).isNotEqualTo(nullCar);
    }


}
