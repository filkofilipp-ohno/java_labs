package org.example;

public interface Orbitable {
    void orbit();

    double getOrbitTime();

    static void describe() {
        System.out.println("Объект может двигаться по орбите.");
    }
}