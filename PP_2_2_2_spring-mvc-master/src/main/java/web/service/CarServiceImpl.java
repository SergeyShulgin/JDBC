package web.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCarList(int count) {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota", "Corolla", 2008));
        cars.add(new Car("Honda", "Civic", 2015));
        cars.add(new Car("Ford", "Focus", 2012));
        cars.add(new Car("Volkswagen", "Golf", 2010));
        cars.add(new Car("Nissan", "Sedan", 2009));
        return (count > 5) ? cars : cars.subList(0, count);
    }
}
