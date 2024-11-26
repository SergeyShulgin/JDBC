package web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.List;

@Service
public interface CarService {
    List<Car> getCarList(int count);
}
