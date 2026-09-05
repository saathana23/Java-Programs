import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Rule for experienced players
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Rule for newer players
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        // Fantasy points used for ranking
        double fantasyPoints() {
            return battingAverage;
        }

        // Sort in descending order of fantasy points
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.fantasyPoints(), this.fantasyPoints());
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];
        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (Player.isDraftable(players[i].matchesPlayed)
                    || Player.isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        Player[] result = Arrays.copyOf(draftable, count);

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            output += (i + 1) + ". " + result[i].name;

            if (i < result.length - 1) {
                output += " | ";
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            String name = sc.nextLine();
            int matchesPlayed = sc.nextInt();
            double battingAverage = sc.nextDouble();
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(
                name,
                matchesPlayed,
                battingAverage,
                injured
            );
        }

        System.out.println(draftAndRank(players));

        sc.close();
    }
}
