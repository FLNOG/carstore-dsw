package br.com.carstore.model.service;

import br.com.carstore.model.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private int id = 1;
    private List<CarDTO> cars;

    public CarServiceImpl(){
        cars = new ArrayList<>();
    }

    @Override
    public List<CarDTO> findAll() {
        return this.cars;
    }

    @Override
    public void save(CarDTO carDTO) {
        carDTO.setId(id++);
        cars.add(carDTO);
    }

    @Override
    public void deleteById(int id) {
        cars.remove(findById(id));
    }

    @Override
    public void update(int id, CarDTO carDTO) {
        CarDTO update = findById(id);
        update.setName(carDTO.getName());
        update.setColor(carDTO.getColor());
    }

    @Override
    public CarDTO findById(int id) {
        for (CarDTO car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }
}