package org.example;

public class Game extends Software {
    private String genre;
    private int ageRating;

    public Game(String name, String version, double price, String genre, int ageRating) {
        super(name, version, price);
        this.genre = genre;
        this.ageRating = ageRating;
    }

    @Override
    public String getRequirements() {
        return "Высокие требования";
    }

    public void install(String path, boolean multiplayer) {
        System.out.println("Устанавливаю игру в " + path
                + (multiplayer ? " с поддержкой мультиплеера" : ""));
    }

    public void install(int size, String platform) {
        System.out.println("Устанавливаю игру размером " + size
                + " ГБ на платформу " + platform);
    }

    @Override
    public String toString() {
        return "Game{name='" + getName() + "', version='" + getVersion()
                + "', price=" + getPrice() + ", genre='" + genre
                + "', ageRating=" + ageRating + "}";
    }
}
