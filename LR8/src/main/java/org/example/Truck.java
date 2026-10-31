package org.example;

public class Truck extends Carrier {
    private int wheels;

    public Truck(String name, double capacity, double speed, int wheels) {
        super(name, capacity, speed);
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void deliver() {
        System.out.println("Перевозка по суше");
    }

    public void loadCargo() {
        System.out.println("Грузовик " + getName() + " загружен");
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Колёс: %d%n", wheels);
    }
}