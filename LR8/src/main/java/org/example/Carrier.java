package org.example;

public class Carrier {
    private String name;
    private double capacity;
    private double speed;

    public Carrier(String name, double capacity, double speed) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void deliver() {
        System.out.println("Перевозка груза");
    }

    public void displayInfo() {
        System.out.printf("Название: %s | Грузоподъёмность: %.2f | Скорость: %.2f%n",
                name, capacity, speed);
    }
}
