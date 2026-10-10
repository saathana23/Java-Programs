
import java.util.Scanner;

public class ParcelShippingDesk {
    static abstract class Parcel {
        double weight, declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double getCharge();
        abstract double getInsurance();
        abstract String getType();

        double getTotal() {
            return getCharge() + getInsurance();
        }
    }

    static class Standard extends Parcel {
        Standard(double w, double v) { super(w, v); }
        double getCharge() { return 40 + 10 * weight; }
        double getInsurance() { return 0; }
        String getType() { return "STANDARD"; }
    }

    static class Express extends Parcel {
        Express(double w, double v) { super(w, v); }
        double getCharge() { return 80 + 15 * weight; }
        double getInsurance() { return declaredValue * 0.02; }
        String getType() { return "EXPRESS"; }
    }

    static class Fragile extends Parcel {
        Fragile(double w, double v) { super(w, v); }
        double getCharge() { return 40 + 10 * weight + 50; }
        double getInsurance() { return declaredValue * 0.02; }
        String getType() { return "FRAGILE"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels[i] = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new Fragile(weight, value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }
        }

        for (Parcel p : parcels) {
            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                p.getType(), p.getCharge(), p.getInsurance(), p.getTotal()
            );
            grandTotal += p.getTotal();
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}