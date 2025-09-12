package br.com.carstore.model.service;

import br.com.carstore.model.model.CarDTO;

import java.util.List;

public interface CarService {

    List<CarDTO> findAll();

    void save(CarDTO carDTO);

    void deleteById(int id);

    void update(int id, CarDTO carDTO);

    CarDTO findById(int id);

}
