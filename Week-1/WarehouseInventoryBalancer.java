import java.util.Scanner;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] a, int[] b) {
        int sumA = 0, sumB = 0;
        int max = a[0], section = 1, index = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];

            if (a[i] > max) {
                max = a[i];
                section = 1;
                index = i;
            }

            if (b[i] > max) {
                max = b[i];
                section = 2;
                index = i;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + sumA +
                " | Section B Total: " + sumB +
                " | Status: " + status +
                " | Highest Quantity: " + max +
                " (Section " + (section == 1 ? "A" : "B") +
                ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();

        analyzeInventory(a, b);
        sc.close();
    }
}