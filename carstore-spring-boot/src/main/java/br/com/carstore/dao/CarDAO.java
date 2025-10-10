package br.com.carstore.dao;

import br.com.carstore.model.CarDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarDAO {

    private final JdbcTemplate jdbc;

    public CarDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<CarDTO> rowMapper = new RowMapper<>() {

        @Override
        public CarDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CarDTO dto = new CarDTO();
            dto.setName(rs.getString("name"));
            dto.setColor(rs.getString("color"));
            return dto;
        }

    };

    // SELECT * FROM car -> List<CarDTO>
    public List<CarDTO> findAll() {
        String sql = "SELECT name, color FROM car";
        return jdbc.query(sql, rowMapper);

    }

    // INSERT INTO car (name, color)
    public void save(CarDTO carDTO) {
        String sql = "INSERT INTO car (name, color) VALUES (?, ?)";
        jdbc.update(sql, carDTO.getName(), carDTO.getColor());

    }

    // DELETE FROM car WHERE id = ?
    public void deleteById(int id) {
        String sql = "DELETE FROM car WHERE id = ?";
        jdbc.update(sql, id);
        //Retirei jdbc.update(sql, Long.valueOf(id));
    }

    // UPDATE car SET name = ?, color = ? WHERE id = ?
    public void update(int id, CarDTO carDTO) {
        String sql = "UPDATE car SET name = ?, color = ? WHERE id = ?";
        jdbc.update(sql, carDTO.getName(), carDTO.getColor(), id);
        //Retirei jdbc.update(sql, carDTO.getName(), carDTO.getColor(), Long.valueOf(id));

    }

    public void create(String name, String color) {
        CarDTO car = new CarDTO();
        car.setName(name);
        car.setColor(color);
        save(car);
    }
}