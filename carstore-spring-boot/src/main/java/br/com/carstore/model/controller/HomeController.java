package br.com.carstore.model.controller;

import br.com.carstore.model.model.CarDTO;
import br.com.carstore.model.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @GetMapping("/index")
    public String indexTwo(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String createCar(@ModelAttribute CarDTO car, Model model) {
        carService.save(car);
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "dashboard";
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "dashboard";
    }

    @GetMapping("/cars/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        CarDTO car = carService.findById(id);
        model.addAttribute("carDTO", car);
        return "edit";
    }

    @PostMapping("/cars/update/{id}")
    public String updateCar(@PathVariable int id, @ModelAttribute CarDTO carDTO, Model model) {
        carService.update(id, carDTO);
        model.addAttribute("cars", carService.findAll());
        return "dashboard";
    }

    @PostMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable int id, Model model) {
        carService.deleteById(id);
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "dashboard";
    }
}