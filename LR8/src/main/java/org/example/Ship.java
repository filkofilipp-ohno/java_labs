package org.example;

public class Ship extends Carrier {
    private double tonnage;

    public Ship(String name, double capacity, double speed, double tonnage) {
        super(name, capacity, speed);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    public void deliver() {
        System.out.println("Перевозка по воде");
    }

    public void anchor() {
        System.out.println("Корабль " + getName() + " бросил якорь");
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Тоннаж: %.2f%n", tonnage);
    }
}
