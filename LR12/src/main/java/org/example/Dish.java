package org.example;

public abstract class Dish {
    private String name;
    private int id;
    private double volume;

    public Dish(String name, int id, double volume) {
        this.name = name;
        this.id = id;
        this.volume = volume;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public double getVolume() { return volume; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', id=" + id + ", volume=" + volume;
    }
}
