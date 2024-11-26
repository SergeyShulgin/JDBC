package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static final Car[] CARS = {
            new Car("Toyota", "Corolla", 2008),
            new Car("Honda", "Civic", 2015),
            new Car("Ford", "Focus", 2012),
            new Car("Volkswagen", "Golf", 2010),
            new Car("Nissan", "Sedan", 2009)
    };


    @Override
    public List<Car> getCarList(int count) {
        return Arrays.asList(CARS).subList(0, Math.min(count, CARS.length));
    }
}
