package org.example;

public class App {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Коляда А.А.", 67, "Т394"),
                new Student("Лихадиевский Н.А.", 18, "Т394")
        };

        System.out.printf("%-20s%-10s%-5s%n", "ФИО", "Возраст", "Группа");
        students[0].displayInfo();
        students[1].displayInfo();
    }
}
