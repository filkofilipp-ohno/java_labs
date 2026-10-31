package org.example;

public interface Explorable {
    void explore();

    String getResources();

    default void report() {
        System.out.println("Исследование завершено. Ресурсы: " + getResources());
    }
}