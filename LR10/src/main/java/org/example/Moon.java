package org.example;

public class Moon implements Orbitable, Explorable {
    private String name;
    private double orbitTime;
    private String planet;
    private String resources;

    public Moon(String name, double orbitTime, String planet, String resources) {
        this.name = name;
        this.orbitTime = orbitTime;
        this.planet = planet;
        this.resources = resources;
    }

    @Override
    public void orbit() {
        System.out.println("Луна " + name + " вращается вокруг планеты " + planet + ".");
    }

    @Override
    public double getOrbitTime() {
        return orbitTime;
    }

    @Override
    public void explore() {
        System.out.println("Исследуем луну " + name + "...");
    }

    @Override
    public String getResources() {
        return resources;
    }

    @Override
    public String toString() {
        return "Moon{name='" + name + "', orbitTime=" + orbitTime
                + ", planet='" + planet + "', resources='" + resources + "'}";
    }
}
