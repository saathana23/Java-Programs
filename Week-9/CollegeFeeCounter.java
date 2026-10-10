
import java.util.Scanner;

public class CollegeFeeCounter {
    static abstract class Student {
        String name;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateFee();
    }

    static class DayScholar extends Student {
        DayScholar(String name) { super(name); }

        double calculateFee() {
            return 40000 + 12000;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }

        double calculateFee() {
            return 40000 + 60000;
        }
    }

    static class Scholar extends Student {
        Scholar(String name) { super(name); }

        double calculateFee() {
            return 20000 + 12000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new Scholar(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }
        }

        for (Student s : students) {
            double fee = s.calculateFee();
            System.out.printf("%s: %.2f%n", s.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}