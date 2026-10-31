import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    static void main(String[] args) {
        System.out.println("Введите номер задания (1, 2):");
        switch (in.nextInt()) {
            case 1:
                z1();
                break;
            case 2:
                z2();
                break;
            default:
                System.out.println("Неверный номер задания.");
        }
        in.close();
    }

    static void print(int[] mas) {
        for (int i = 0; i < mas.length - 1; i++) {
            System.out.print(mas[i] + ", ");
        }
        System.out.println(mas[mas.length - 1] + ".");
    }

    static void z1() {
        int[] mas = new int[15];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(10);
        }
        System.out.println("Массив:");
        print(mas);
        System.out.println("Уникальные числа:");
        for (int i = 0; i < mas.length; i++) {
            boolean was = false;
            for (int j = 0; j < i; j++) {
                if (mas[i] == mas[j]) {
                    was = true;
                    break;
                }
            }
            if (!was) {
                System.out.print(mas[i] + " ");
            }
        }

    }

    static void z2() {
        int size = 5;
        int[][] a = new int[size][size];
        System.out.println("Массив:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rand.nextInt(11) - 5;
            }
            print(a[i]);
        }
        int chislo = 0;
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 2; j++) {
                if (a[i][j] > 0) {
                    chislo++;
                    sum += a[i][j];
                }
            }
        }
        System.out.println("Число положительных: " + chislo + "\nСумма положительных: " + sum);
    }

}