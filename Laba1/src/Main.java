import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    static void main(String[] args) {
        System.out.println("Выберите задание (1, 2, 3):");
        switch (in.nextInt()) {
            case 1:
                zadanie1();
                break;
            case 2:
                zadanie2();
                break;
            case 3:
                zadanie3();
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    public static void zadanie1() {
        System.out.println("Введите градусы в кельвинах:");
        double K = in.nextDouble();
        double C = 273.15;
        System.out.println("В градусах цельсия: " + (K - C));
    }

    public static void zadanie2() {
        System.out.println("Введите целое число:");
        int ch = in.nextInt();
        if (ch % 7 == 0 ^ ch % 11 == 0) {
            System.out.println("Число кратно 7 или 11 и не одновременно.");
        } else {
            System.out.println("Число не кратно 7 или 11 или кратно одновременно.");
        }
    }


    public static void zadanie3() {
        System.out.println("Введите целое число:");
        int ch = Math.abs(in.nextInt());
        int max = 0;
        while (ch > 0) {
            int last = ch / 10 % 10;
            if (last > max) {
                max = last;
            }
            ch /= 10;
        }
        System.out.println("Максимальная цифра в числе: " + max);
    }

}