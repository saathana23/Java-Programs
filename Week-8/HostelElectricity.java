
import java.util.Scanner;

public class HostelElectricity {
    static abstract class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculateBill();

        abstract String getType();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 8.0;
        }

        String getType() {
            return "SINGLE";
        }
    }

    static class SharedRoom extends Room {
        int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double calculateBill() {
            return (units * 6.0) / occupants;
        }

        String getType() {
            return "SHARED";
        }
    }

    static class ACRoom extends Room {
        ACRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 10.0 + 200;
        }

        String getType() {
            return "AC";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Room[] rooms = new Room[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    rooms[i] = new ACRoom(units);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid room type");
            }
        }

        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f%n", r.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}