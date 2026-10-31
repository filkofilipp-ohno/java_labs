package org.example;

public class App {
    public static void main(String[] args) {
        Course[] cources = {
                new Course("Математика", 60, 25),
                new Course("Физика", 48, 18),
                new Course("История", 36, 30),
                new Course("Химия", 52, 22)
        };

        System.out.println(Course.getAverageStudents());
    }
}
