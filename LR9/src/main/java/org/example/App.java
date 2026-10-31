package org.example;

public class App {
    public static void main(String[] args) {
        Weapon[] weapons = {
                new Sword("Рыцарский меч", 50, 1, 9),
                new Sword("Катана", 45, 1, 10),
                new Sword("Короткий меч", 30, 1, 7),
                new Bow("Длинный лук", 35, 150, 20),
                new Bow("Короткий лук", 25, 80, 12)
        };

        for (Weapon weapon : weapons) {
            weapon.displayInfo();
            System.out.println("Тип оружия: " + weapon.getType());

            System.out.print("Атака: ");
            weapon.attack();

            System.out.println("-------------------------");
        }
    }
}
