package br.com.carstore.service;

import br.com.carstore.dao.CarDAO;
import br.com.carstore.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDAO carDao;

    public CarServiceImpl(CarDAO carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<CarDTO> findAll() {
        return carDao.findAll();

    }

    @Override
    public void save(CarDTO carDTO) {
        carDao.save(carDTO);

    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);

    }

    @Override
    public void update(int id, CarDTO carDTO) {
        carDao.update(id, carDTO);

    }

    @Override
    public CarDTO findById(int id) {
        return null; //Implementar o procurar por id
    }
}