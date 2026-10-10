
import java.util.Scanner;

public class CityCabFareMeter {
    static abstract class Cab {
        double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double getRate();
        abstract boolean supportsNight();
        abstract String getType();

        double calculateFare(String time) {
            double fare = Math.max(100, km * getRate());

            if (time.equals("NIGHT")) {
                fare *= 1.20;
            }

            return fare;
        }
    }

    static class Mini extends Cab {
        Mini(double km) { super(km); }
        double getRate() { return 10; }
        boolean supportsNight() { return false; }
        String getType() { return "MINI"; }
    }

    static class Sedan extends Cab {
        Sedan(double km) { super(km); }
        double getRate() { return 14; }
        boolean supportsNight() { return true; }
        String getType() { return "SEDAN"; }
    }

    static class SUV extends Cab {
        SUV(double km) { super(km); }
        double getRate() { return 18; }
        boolean supportsNight() { return true; }
        String getType() { return "SUV"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] times = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            switch (type) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;
                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }

            times[i] = time;
        }

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];

            if (times[i].equals("NIGHT") && !cab.supportsNight()) {
                System.out.println(cab.getType() + ": night service not available");
            } else {
                double fare = cab.calculateFare(times[i]);
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}