package org.example;

public class App {
    public static void main(String[] args) {
        Carrier[] carriers = new Carrier[5];

        carriers[0] = new Ship("Титаник", 1000.0, 30.0, 5000.0);
        carriers[1] = new Ship("Аврора", 800.0, 25.0, 4000.0);
        carriers[2] = new Ship("Виктория", 1200.0, 28.0, 6000.0);
        carriers[3] = new Truck("Volvo FH", 20.0, 90.0, 6);
        carriers[4] = new Truck("Scania R", 25.0, 85.0, 8);

        for (Carrier c : carriers) {
            System.out.println("=== " + c.getClass().getSimpleName() + " ===");
            c.displayInfo();
            c.deliver();

            if (c instanceof Ship) {
                Ship s = (Ship) c;
                s.anchor();
            } else if (c instanceof Truck) {
                Truck t = (Truck) c;
                t.loadCargo();
            }
            System.out.println();
        }
    }
}
