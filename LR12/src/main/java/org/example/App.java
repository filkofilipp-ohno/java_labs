package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class App
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задание (1 - Посуда, 2 - Аудиокниги): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private static void task1() {
        Map<String, Dish> dishes = new LinkedHashMap<>();

        dishes.put("Plate1", new Plate("Тарелка1", 1, 0.5, 25.0));
        dishes.put("Plate2", new Plate("Тарелка2", 2, 0.6, 27.0));
        dishes.put("Plate3", new Plate("Тарелка3", 3, 0.4, 22.0));
        dishes.put("Cup1", new Cup("Чашка1", 4, 0.3, true));
        dishes.put("Cup2", new Cup("Чашка2", 5, 0.25, false));
        dishes.put("Cup3", new Cup("Чашка3", 6, 0.35, true));
        dishes.put("Bowl1", new Bowl("Миска1", 7, 1.2, 10.0));
        dishes.put("Bowl2", new Bowl("Миска2", 8, 1.5, 12.0));

        for (Map.Entry<String, Dish> entry : dishes.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    private static void task2() {
        List<AudioBook> books = new ArrayList<>(Arrays.asList(
                new AudioBook(1, "Война и мир", "Л. Толстой", 4, Arrays.asList(5, 4, 3, 4)),
                new AudioBook(2, "Преступление и наказание", "Ф. Достоевский", 3, Arrays.asList(2, 3, 2, 2)),
                new AudioBook(3, "Мастер и Маргарита", "М. Булгаков", 5, Arrays.asList(5, 5, 4, 5)),
                new AudioBook(7, "Астер и Маргарита", "М. Булгаков", 5, Arrays.asList(5, 5, 4, 5)),
                new AudioBook(4, "Отцы и дети", "И. Тургенев", 2, Arrays.asList(1, 2, 3, 1)),
                new AudioBook(5, "Евгений Онегин", "А. Пушкин", 4, Arrays.asList(4, 4, 5, 4)),
                new AudioBook(6, "Тихий Дон", "М. Шолохов", 3, Arrays.asList(3, 3, 2, 3))
        ));

        System.out.println("Исходный список");
        books.forEach(System.out::println);

        AudioBookService.removeLowRated(books);
        System.out.println("\nПосле удаления (avg < 3)");
        books.forEach(System.out::println);

        AudioBookService.raiseRating(books);
        System.out.println("\nПосле повышения рейтинга (avg >= 4)");
        books.forEach(System.out::println);

        System.out.println();
        AudioBookService.printAudioBooks(books, 5);

        System.out.println();
        AudioBookService.sortAndPrint(books);
    }
}
