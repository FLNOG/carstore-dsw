package br.com.carstore.model;

import jakarta.validation.constraints.Size;

public class CarDTO {

    @Size(min = 1, max = 5, message = "O campo excedeu o limite!")
    private String name;

    private String color;

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