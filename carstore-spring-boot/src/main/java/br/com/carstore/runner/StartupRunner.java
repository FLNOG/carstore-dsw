package br.com.carstore.runner;

import br.com.carstore.dao.CarDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final CarDAO CarDao;

    public StartupRunner(CarDAO CarDao) {

        this.CarDao = CarDao;

    }

    @Override
    public void run(String... args) throws Exception {
        CarDao.create("Fusca", "Azul");
        CarDao.create("Civic", "Preto");
        System.out.println(CarDao.findAll());
    }
}