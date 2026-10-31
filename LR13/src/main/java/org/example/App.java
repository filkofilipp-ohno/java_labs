package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Inn> inns = new ArrayList<>();

        try {
            inns.add(new Inn("Уют", "Минск", 10, 50.0, 4.5));
            inns.add(new Inn("Комфорт", "Гомель", 5, 75.0, 4.0));
            inns.add(new Inn("Люкс", "Брест", 8, 120.0, 5.0));
            System.out.println("Созданы гостиницы:");
            for (Inn inn : inns) {
                System.out.println(inn);
            }
        } catch (InvalidInnDataException e) {
            System.out.println("Ошибка создания гостиницы: " + e.getMessage());
        }

        System.out.println("\n--- Операции бронирования ---");

        try {
            Inn inn1 = findInn(inns, "Уют");
            inn1.bookRoom("Иванов", 3);
            inn1.bookRoom("Петров", 2);
        } catch (InnNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (BookingException e) {
            System.out.println("Ошибка бронирования: " + e.getMessage());
        }

        try {
            Inn inn2 = findInn(inns, "Комфорт");
            inn2.bookRoom("Сидоров", 5);
            inn2.bookRoom("Козлов", 1);
            inn2.bookRoom("Смирнов", 2);
            inn2.bookRoom("Волков", 1);
            inn2.bookRoom("Зайцев", 3);
            inn2.bookRoom("Лебедев", 2);
        } catch (InnNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (BookingException e) {
            System.out.println("Ошибка бронирования: " + e.getMessage());
        }

        try {
            Inn inn3 = findInn(inns, "Люкс");
            inn3.bookRoom("Морозов", 4);
        } catch (InnNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (BookingException e) {
            System.out.println("Ошибка бронирования: " + e.getMessage());
        }

        System.out.println("\n--- Операции выселения ---");

        try {
            Inn inn1 = findInn(inns, "Уют");
            inn1.checkOut("Иванов");
        } catch (InnNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (BookingException e) {
            System.out.println("Ошибка выселения: " + e.getMessage());
        }

        try {
            Inn inn1 = findInn(inns, "Уют");
            inn1.checkOut("Неизвестный");
        } catch (InnNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (BookingException e) {
            System.out.println("Ошибка выселения: " + e.getMessage());
        }

        try {
            Inn inn2 = findInn(inns, "Комфорт");
            inn2.checkOut("Сидоров");
        } catch (InnNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (BookingException e) {
            System.out.println("Ошибка выселения: " + e.getMessage());
        }

        System.out.println("\n--- Итоговое состояние гостиниц ---");
        for (Inn inn : inns) {
            System.out.println(inn);
        }

        System.out.println("\n--- Попытка создания гостиницы с некорректными данными ---");
        try {
            new Inn("", "Минск", 10, 50.0, 4.5);
        } catch (InvalidInnDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new Inn("Тест", "Минск", -1, 50.0, 4.5);
        } catch (InvalidInnDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            new Inn("Тест", "Минск", 10, 0, 4.5);
        } catch (InvalidInnDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new Inn("Тест", "Минск", 10, 50.0, 7.0);
        } catch (InvalidInnDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static Inn findInn(List<Inn> inns, String name) throws InnNotFoundException {
        for (Inn inn : inns) {
            if (inn.getName().equals(name)) {
                return inn;
            }
        }
        throw new InnNotFoundException("Гостиница с названием \"" + name + "\" не найдена");
    }
}
