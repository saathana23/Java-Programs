
import java.util.Scanner;

public class HomeApplianceEnergy {
    static abstract class Appliance {
        double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double getPower();
        abstract boolean supportsSaver();
        abstract String getType();

        double calculateUnits(boolean saver) {
            double units = getPower() * hours / 1000.0;

            if (saver) {
                units *= 0.75;
            }

            return units;
        }

        double calculateCost(double units) {
            return units * 8.0;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) { super(hours); }
        double getPower() { return 150; }
        boolean supportsSaver() { return false; }
        String getType() { return "FRIDGE"; }
    }

    static class AC extends Appliance {
        AC(double hours) { super(hours); }
        double getPower() { return 1500; }
        boolean supportsSaver() { return true; }
        String getType() { return "AC"; }
    }

    static class TV extends Appliance {
        TV(double hours) { super(hours); }
        double getPower() { return 100; }
        boolean supportsSaver() { return false; }
        String getType() { return "TV"; }
    }

    static class Washer extends Appliance {
        Washer(double hours) { super(hours); }
        double getPower() { return 500; }
        boolean supportsSaver() { return true; }
        String getType() { return "WASHER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Appliance[] appliances = new Appliance[n];
        boolean[] saverModes = new boolean[n];
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AC(hours);
                    break;
                case "TV":
                    appliances[i] = new TV(hours);
                    break;
                case "WASHER":
                    appliances[i] = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance type");
            }

            saverModes[i] = saver;
        }

        for (int i = 0; i < n; i++) {
            Appliance a = appliances[i];
            boolean saver = saverModes[i];

            if (saver && !a.supportsSaver()) {
                System.out.println(a.getType() + ": saver mode not supported");
                continue;
            }

            double units = a.calculateUnits(saver);
            double cost = a.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                a.getType(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}