package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AudioBookService {

    public static void removeLowRated(List<AudioBook> books) {
        books.removeIf(b -> b.getAverageRating() < 3);
    }

    public static void raiseRating(List<AudioBook> books) {
        for (AudioBook b : books) {
            if (b.getAverageRating() >= 4) {
                b.setRating(Math.min(5, b.getRating() + 1));
            }
        }
    }

    public static void printAudioBooks(List<AudioBook> books, int rating) {
        System.out.println("Аудиокниги с рейтингом " + rating);
        books.stream()
                .filter(b -> b.getRating() == rating)
                .forEach(System.out::println);
    }

    public static void sortAndPrint(List<AudioBook> books) {
        List<AudioBook> sorted = books.stream()
                .sorted(Comparator
                        .comparingDouble(AudioBook::getAverageRating).reversed()
                        .thenComparing(AudioBook::getTitle))
                .collect(Collectors.toList());

        System.out.println("Отсортировано (ID | название | средний рейтинг)");
        for (AudioBook b : sorted) {
            System.out.printf("%d | %s | %.2f%n",
                    b.getId(), b.getTitle(), b.getAverageRating());
        }
    }
}
