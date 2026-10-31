import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Scanner in = new Scanner(System.in);

    static void main(String[] args) {
        System.out.println("Введите номер задания:");
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
            case 4:
                z4();
                break;
            default:
                System.out.println("Неверный номер задания.");
        }
        in.close();
    }

    static void z1() {
        System.out.println("Введите строку:");
        in.nextLine();
        String stroka = in.nextLine();
        if (stroka.contains("Java")) {
            System.out.println("Содержит");
        } else {
            System.out.println("Не содержит");
        }
    }

    static void z2() {
        System.out.println("Введите строку:");
        in.nextLine();

        String stroka = (in.nextLine()).toLowerCase().replace(" ", "");

        int left = 0;
        int right = stroka.length() - 1;

        boolean is_pali = true;
        while (left < right) {
            if (stroka.charAt(left) != stroka.charAt(right)) {
                System.out.println("Не палиндром");
                is_pali = false;
                break;
            }
            left++;
            right--;
        }
        if (is_pali) {
            System.out.println("Палиндром");
        }
    }

    static public class Employee {
        public String fullname;
        public Double salary;

        public Employee(String fullname, double salary) {
            this.fullname = fullname;
            this.salary = salary;
        }
    }

    static public class Report {
        public static void generateReport(Employee[] e) {
            System.out.println("Сотрудники и их зарплата:");
            System.out.printf("%-15s | %5s%n", "ФИО", "ЗП");
            System.out.println("-----------------------------------");
            for (int i = 0; i < e.length; i++) {
                System.out.printf("%-15s | %10.2f руб.%n", e[i].fullname, e[i].salary);
            }
        }
    }

    static void z3() {
        Employee[] employees = {
                new Employee("Иванов И.И.", 55000.5),
                new Employee("Петров П.П.", 72000.0),
                new Employee("Сидоров С.С.", 48000.756)
        };

        Report.generateReport(employees);
    }

    static void z4(){
        String s = "a1a a2b a3c a4d a5e";

        Pattern pattern = Pattern.compile("a\\d[b-e]");
        Matcher matcher = pattern.matcher(s);

        System.out.println("Подходящие слова:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}