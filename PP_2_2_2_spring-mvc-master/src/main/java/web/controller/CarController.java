package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.model.Car;
import web.service.CarServiceImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String printCars(@RequestParam(defaultValue = "5") int count, ModelMap model) {
        CarServiceImpl carServiceimpl = new CarServiceImpl();
        List<Car> qtyCarService = carServiceimpl.getCarList(count);
        model.addAttribute("cars", qtyCarService);
        return "cars";
    }
}
