package br.com.carstore.model;

public class Car {

    private String id;
    private String name;
    private String color;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Car(String id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor(){
        return color;
    }
}