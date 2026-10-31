package org.example;

public class Software {
    private String name;
    private String version;
    private double price;

    public Software(String name, String version, double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public void install() {
        System.out.println("Устанавливаю");
    }

    public void install(String path) {
        System.out.println("Устанавливаю в " + path);
    }

    public void install(int size) {
        System.out.println("Устанавливаю размером " + size + " ГБ");
    }

    public String getRequirements() {
        return "Стандартные требования";
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Software{name='" + name + "', version='" + version
                + "', price=" + price + "}";
    }
}
