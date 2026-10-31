package org.example;

public class App {
    public static void main(String[] args) {
        Orbitable.describe();

        Orbitable[] orbitables = new Orbitable[]{
                new Planet("Земля", 1.0, "вода, железо, кремний"),
                new Planet("Марс", 1.88, "железо, оксиды"),
                new Planet("Юпитер", 11.86, "водород, гелий"),
                new Moon("Луна", 27.3, "Земля", "реголит, гелий-3"),
                new Moon("Титан", 15.9, "Сатурн", "метан, азот")
        };

        System.out.println("\n=== Движение по орбите ===");
        for (Orbitable o : orbitables) {
            o.orbit();
            System.out.println("  Период обращения: " + o.getOrbitTime());
        }

        System.out.println("\n=== Исследование объектов ===");
        for (Orbitable o : orbitables) {
            if (o instanceof Explorable) {
                Explorable e = (Explorable) o;
                e.explore();
                e.report();
            }
            System.out.println();
        }
    }
}
