package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.model.Car;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @PostMapping("/create-car")
    public String createCar(@Valid @ModelAttribute CarDTO car, BindingResult result) {

        if (result.hasErrors()){
            return "index";
        }

        System.out.println(car.getName() + " " + car.getColor());
        return "dashboard";

    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }
}