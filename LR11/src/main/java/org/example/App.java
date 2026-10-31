package org.example;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("=== Демонстрация перегрузки ===");

        Software base = new Software("Antivirus", "1.0", 29.99);
        base.install();
        base.install("/usr/local/antivirus");
        base.install(2);

        Game game = new Game("CyberQuest", "2.5", 59.99, "RPG", 16);
        game.install();
        game.install("D:/Games/CyberQuest");
        game.install(85);
        game.install("D:/Games/CyberQuest", true);
        game.install(85, "Windows");

        Editor editor = new Editor("TextMaster", "4.1", 0.0, "TXT", true);
        editor.install();
        editor.install("C:/Tools/TextMaster");
        editor.install(1);
        editor.install("C:/Tools/TextMaster", "RU");
        editor.install(1, true);

        System.out.println("\n=== Демонстрация переопределения (полиморфизм) ===");

        Software[] software = new Software[] {
                new Software("Antivirus", "1.0", 29.99),
                new Game("CyberQuest", "2.5", 59.99, "RPG", 16),
                new Editor("TextMaster", "4.1", 0.0, "TXT", true)
        };

        for (Software s : software) {
            System.out.println(s);
            System.out.println("  Требования: " + s.getRequirements());
            s.install();
            System.out.println();
        }

        System.out.println("=== Статический vs динамический полиморфизм ===");

        Software ref = new Game("SpaceWar", "1.0", 39.99, "Action", 12);

        System.out.println("Статический (перегрузка, выбор на этапе компиляции):");
        ref.install();
        ref.install("/games/spacewar");
        ref.install(50);

        System.out.println("\nДинамический (переопределение, выбор во время выполнения):");
        System.out.println("getRequirements() -> " + ref.getRequirements());

        if (ref instanceof Game) {
            Game g = (Game) ref;
            g.install("/games/spacewar", true);
            g.install(50, "Linux");
        }
    }
}
