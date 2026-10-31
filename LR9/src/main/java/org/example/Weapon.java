package org.example;

public abstract class Weapon {
    private String name;
    private int damage;
    private int range;

    public Weapon(String name, int damage, int range) {
        this.name = name;
        this.damage = damage;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public abstract void attack();

    public abstract String getType();

    public void displayInfo() {
        System.out.printf("Название: %s | Урон: %d | Дальность: %d м%n",
                name, damage, range);
    }
}