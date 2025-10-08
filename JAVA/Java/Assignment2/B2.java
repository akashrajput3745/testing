import java.util.Scanner;
class CricketPlayer {
    String name;
    int no_of_innings;
    int no_of_times_notout;
    int total_runs;
    float bat_avg;
    CricketPlayer(String name, int innings, int notout, int runs) {
        this.name = name;
        this.no_of_innings = innings;
        this.no_of_times_notout = notout;
        this.total_runs = runs;
        this.bat_avg = avg(innings, notout, runs);
    }
    static float avg(int innings, int notout, int runs) {
        int dismissals = innings - notout;
        if (dismissals == 0) return runs; 
        return (float) runs / dismissals;
    }
    static void sort(CricketPlayer[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = i + 1; j < players.length; j++) {
                if (players[j].bat_avg > players[i].bat_avg) {
                    CricketPlayer temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
    void display() {
        System.out.printf("%-15s %-10d %-10d %-10d %-10.2f\n",
            name, no_of_innings, no_of_times_notout, total_runs, bat_avg);
    }
}
public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        CricketPlayer[] players = new CricketPlayer[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for player " + (i + 1));
            sc.nextLine(); // clear buffer
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("No. of Innings: ");
            int innings = sc.nextInt();
            System.out.print("No. of Times Not Out: ");
            int notout = sc.nextInt();
            System.out.print("Total Runs: ");
            int runs = sc.nextInt();
            players[i] = new CricketPlayer(name, innings, notout, runs);
        }
        CricketPlayer.sort(players);
        System.out.println("\n--- Player Details Sorted by Batting Average ---");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s\n",
            "Name", "Innings", "NotOut", "Runs", "Average");
        for (CricketPlayer p : players) {
            p.display();
        }
    }
}