import java.util.Scanner;

public class MatchDayGridAnalyzer {

    static double rowAverage(int[] row) {
        int sum = 0;

        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {

        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {

            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold) {
                result += "Match " + i + ": Power Surge";
            } else {
                result += "Match " + i + ": Normal";
            }

            if (i < runsPerOver.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int matches = sc.nextInt();

        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {

            int overs = sc.nextInt();

            runsPerOver[i] = new int[overs];

            for (int j = 0; j < overs; j++) {
                runsPerOver[i][j] = sc.nextInt();
            }
        }

        int threshold = sc.nextInt();

        System.out.println(classifyMatches(runsPerOver, threshold));

        sc.close();
    }
}