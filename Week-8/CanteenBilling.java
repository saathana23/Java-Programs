
import java.util.Scanner;

public class CanteenBilling {
    static abstract class Customer {
        double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double calculateBill();

        abstract String getType();
    }

    static class Student extends Customer {
        Student(double amount) {
            super(amount);
        }

        double calculateBill() {
            return amount * 0.90;
        }

        String getType() {
            return "STUDENT";
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super(amount);
        }

        double calculateBill() {
            return amount * 0.95;
        }

        String getType() {
            return "STAFF";
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super(amount);
        }

        double calculateBill() {
            return amount + 10;
        }

        String getType() {
            return "GUEST";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Customer[] customers = new Customer[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers[i] = new Student(amount);
                    break;
                case "STAFF":
                    customers[i] = new Staff(amount);
                    break;
                case "GUEST":
                    customers[i] = new Guest(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid customer type");
            }
        }

        for (Customer c : customers) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", c.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}