
import java.util.Scanner;

public class MovieTicketCounter {
    static final double CONVENIENCE_FEE = 20.0;

    static abstract class Seat {
        int count;

        Seat(int count) {
            this.count = count;
        }

        abstract double getPrice();
        abstract String getType();

        double calculateAmount() {
            return count * (getPrice() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Seat {
        Regular(int count) { super(count); }
        double getPrice() { return 150; }
        String getType() { return "REGULAR"; }
    }

    static class Premium extends Seat {
        Premium(int count) { super(count); }
        double getPrice() { return 250; }
        String getType() { return "PREMIUM"; }
    }

    static class Recliner extends Seat {
        Recliner(int count) { super(count); }
        double getPrice() { return 400; }
        String getType() { return "RECLINER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Seat[] seats = new Seat[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            switch (type) {
                case "REGULAR": seats[i] = new Regular(count); break;
                case "PREMIUM": seats[i] = new Premium(count); break;
                case "RECLINER": seats[i] = new Recliner(count); break;
                default: throw new IllegalArgumentException("Invalid seat type");
            }
        }

        for (Seat seat : seats) {
            double amount = seat.calculateAmount();
            System.out.printf("%s: %.2f%n", seat.getType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
