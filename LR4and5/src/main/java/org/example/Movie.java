package org.example;

class Movie {
    public String title;
    public String director;
    public int year;
    public int rating;

    public Movie(String t, String d, int y, int r) {
        title = t;
        director = d;
        year = y;
        rating = r;
    }

    public boolean isExcellent() {
        return rating >= 8;
    }
}
