package org.example;

import java.util.ArrayList;
import java.util.List;

public class AudioBook {
    private int id;
    private String title;
    private String author;
    private int rating;
    private List<Integer> listenerRatings;

    public AudioBook(int id, String title, String author, int rating,
                     List<Integer> listenerRatings) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.listenerRatings = new ArrayList<>(listenerRatings);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public List<Integer> getListenerRatings() { return listenerRatings; }

    public double getAverageRating() {
        if (listenerRatings.isEmpty()) return 0.0;
        return listenerRatings.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("AudioBook{id=%d, title='%s', author='%s', rating=%d, avg=%.2f}",
                id, title, author, rating, getAverageRating());
    }
}
