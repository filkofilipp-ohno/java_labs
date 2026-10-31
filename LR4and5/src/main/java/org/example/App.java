package org.example;

import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите номер задания: ");
        switch (in.nextInt()) {
            case 1:
                z1();
                break;
            case 2:
                z2();
                break;
            case 3:
                z3();
                break;
        }
    }

    static void z1() {
        Movie movie = new Movie("Заголовок", "Директор", 2000, 9);

        System.out.println("isExcellent()?: " + movie.isExcellent());
    }

    static void z2() {
        Shop[] shops = {new Shop("Магазин 1", 100.4, 3),
                new Shop("Магазин 2", 50.2, 2),
                new Shop("Магазин 3", 200, 6),
                new Shop("Магазин 4", 700.7, 5),
                new Shop("Магазин 5", 222.22, 2)};

        int maxArea = 0;
        int maxEmployees = 0;

        for (int i = 1; i < shops.length; i++) {
            if (shops[i].area > shops[maxArea].area) {
                maxArea = i;
            }
            if (shops[i].employees > shops[maxEmployees].employees) {
                maxEmployees = i;
            }
        }

        System.out.println("Магазин с максимальной площадью: " + shops[maxArea].name
                + "\nМагазин с максимальным числом сотрудников: " + shops[maxEmployees].name);
        System.out.println(shops[maxEmployees].toString());
    }

    static void z3() {
        Exam[] exam = {
                new Exam("Математика", ExamResult.EXCELLENT),
                new Exam("Русский язык", ExamResult.FAIL),
                new Exam("Белорусский язык", ExamResult.PASS),
                new Exam("Химия", ExamResult.PASS),
                new Exam("Черчение", ExamResult.PASS),
                new Exam("Физика", ExamResult.EXCELLENT)
        };

        System.out.println("Экзамены с результатами 'Восхитительно': ");
        for(int i = 0; i<exam.length;i++){
            if(exam[i].result == ExamResult.EXCELLENT){
                System.out.println(exam[i].subject);
            }
        }
    }

}

