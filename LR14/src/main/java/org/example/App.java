package org.example;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите задание: ");
        int task = CONSOLE.nextInt();
        CONSOLE.nextLine();
        switch (task) {
            case 1: task1(); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            case 5: task5(); break;
            default: System.out.println("Неверный номер задания");
        }
    }

    private static void task1() {
        String fileName = "drink.txt";
        String content = "Мой любимый напиток: кофе\nОписание: бодрящий, ароматный, чёрный.\nРекомендация: пить утром.";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
            return;
        }
        File file = new File(fileName);
        System.out.println("=== Данные о файле ===");
        System.out.println("Имя файла: " + file.getName());
        System.out.println("Размер: " + file.length() + " байт");
        System.out.println("Последнее изменение: " + new Date(file.lastModified()));
        System.out.println("Путь: " + file.getAbsolutePath());
        System.out.println("Существует: " + file.exists());
        System.out.println("Можно читать: " + file.canRead());
        System.out.println("Можно писать: " + file.canWrite());
        System.out.println("Это файл: " + file.isFile());
        System.out.println("Это каталог: " + file.isDirectory());
        System.out.println("\n=== Содержимое файла ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private static void task2() {
        String fileName = "f.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            System.out.println("Введите 10 целых чисел:");
            for (int i = 0; i < 10; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                writer.println(CONSOLE.nextInt());
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
            return;
        }
        System.out.println("\nЧисла из файла:");
        int count = 0;
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");
                if (num % 2 == 0 && num % 3 != 0) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
        }
        System.out.println("\nКоличество чисел, кратных 2 и не кратных 3: " + count);
    }

    private static void task3() {
        String fName = "f.txt";
        String gName = "g.txt";
        String hName = "h.txt";
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fName))) {
            for (int i = 0; i < 20; i++) {
                writer.println(random.nextInt(101) - 50);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи f: " + e.getMessage());
            return;
        }
        try (Scanner scanner = new Scanner(new File(fName));
             PrintWriter gWriter = new PrintWriter(new FileWriter(gName));
             PrintWriter hWriter = new PrintWriter(new FileWriter(hName))) {
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num % 3 == 0 && num % 5 != 0) {
                    gWriter.println(num);
                } else {
                    hWriter.println(num);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка обработки: " + e.getMessage());
            return;
        }
        System.out.println("Исходный файл f.txt:");
        printFile(fName);
        System.out.println("\nФайл g.txt (кратные 3 и не кратные 5):");
        printFile(gName);
        System.out.println("\nФайл h.txt (остальные):");
        printFile(hName);
    }

    private static void task4() {
        String fileName = "ph.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            System.out.println("Введите 12 значений pH:");
            for (int i = 0; i < 5; i++) {
                System.out.print("pH " + (i + 1) + ": ");
                writer.println(((CONSOLE.nextLine()).replace('.', ',')));
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
            return;
        }
        double sum = 0.0;
        int count = 0;
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextDouble()) {
                sum += fileScanner.nextDouble();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
            
        }
        if (count > 0) {
            System.out.printf("Средний pH: %.2f%n", sum / count);
        } else {
            System.out.println("Нет данных для вычисления.");
        }
    }

    private static void task5() {
        String fileName = "f.txt";
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < 10; i++) {
                writer.println(random.nextInt(101) - 20);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
            return;
        }
        int count = 0;
        System.out.println("Числа в файле:");
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.print(num + " ");
                if (num < 30) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
        }
        System.out.println("\nКоличество чисел, меньших 30: " + count);
    }

    private static void printFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + fileName);
        }
    }
}