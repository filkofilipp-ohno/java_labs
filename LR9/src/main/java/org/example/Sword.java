package org.example;

public class Sword extends Weapon {
    private int sharpness;

    public Sword(String name, int damage, int range, int sharpness) {
        super(name, damage, range);
        this.sharpness = sharpness;
    }

    public int getSharpness() {
        return sharpness;
    }

    public void setSharpness(int sharpness) {
        this.sharpness = sharpness;
    }

    @Override
    public void attack() {
        System.out.println("Рубящий удар");
    }

    @Override
    public String getType() {
        return "Холодное оружие";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Острота: " + sharpness + "/10");
    }
}