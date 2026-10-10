
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StreamingRenewal {
    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int getValidityDays();

        LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class Basic extends Plan {
        Basic(String name, LocalDate date) {
            super(name, date);
        }

        int getValidityDays() {
            return 30;
        }
    }

    static class Standard extends Plan {
        Standard(String name, LocalDate date) {
            super(name, date);
        }

        int getValidityDays() {
            return 90;
        }
    }

    static class Premium extends Plan {
        Premium(String name, LocalDate date) {
            super(name, date);
        }

        int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Plan[] plans = new Plan[n];
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next(), formatter);

            switch (type) {
                case "BASIC":
                    plans[i] = new Basic(name, date);
                    break;
                case "STANDARD":
                    plans[i] = new Standard(name, date);
                    break;
                case "PREMIUM":
                    plans[i] = new Premium(name, date);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid plan type");
            }
        }

        for (Plan p : plans) {
            System.out.println(
                    p.name + ": " +
                    p.getRenewalDate().format(formatter)
            );
        }

        sc.close();
    }
}