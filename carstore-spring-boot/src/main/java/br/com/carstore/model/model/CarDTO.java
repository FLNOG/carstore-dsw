package br.com.carstore.model.model;

import jakarta.validation.constraints.Size;

public class CarDTO {

    private int id;
    @Size(min = 1, max = 5, message = "O campo excedeu o limite!")
    private String name;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}