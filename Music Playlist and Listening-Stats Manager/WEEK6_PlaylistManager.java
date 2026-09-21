import java.util.Scanner;

public class WEEK6_PlaylistManager {
    private static final int MAX_SONGS = 5;
    private static String[] titles = new String[MAX_SONGS];
    private static int[] durations = new int[MAX_SONGS];
    private static int[][] stats = new int[2][MAX_SONGS]; // Row 0: Play Count, Row 1: Total Played Time
    private static int songCount = 0;

    public static void printPlaylist() {
        if (songCount == 0) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("\n[PLAYLIST LIST]");
        for (int i = 0; i < songCount; i++) {
            System.out.println("Track [" + i + "]: " + titles[i] + " (" + durations[i] + "s)");
        }
    }

    public static void printStats() {
        if (songCount == 0) {
            System.out.println("No stats available.");
            return;
        }
        System.out.println("\n[PLAYBACK STATS]");
        for (int i = 0; i < songCount; i++) {
            System.out.println("-> " + titles[i] + " | Played: " + stats[0][i] + " times | Total Time: " + stats[1][i] + "s");
        }
    }

    // Recursive sum of track lengths
    public static int calculateTotalTime(int[] durationsArr, int index) {
        if (index < 0) {
            return 0;
        }
        return durationsArr[index] + calculateTotalTime(durationsArr, index - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial sample data
        titles[0] = "Bohemian Rhapsody";
        durations[0] = 354;
        songCount++;

        titles[1] = "Hotel California";
        durations[1] = 390;
        songCount++;

        int choice;
        do {
            System.out.println("\n=================================");
            System.out.println("  MUSIC PLAYLIST & STATS SYSTEM  ");
            System.out.println("=================================");
            System.out.println("1. View Playlist");
            System.out.println("2. Play Song & Update Stats");
            System.out.println("3. Calculate Total Time (Recursive)");
            System.out.println("4. Exit");
            System.out.print("Enter option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printPlaylist();
                    break;
                case 2:
                    printPlaylist();
                    if (songCount > 0) {
                        System.out.print("\nEnter song index to play (0 to " + (songCount - 1) + "): ");
                        int index = scanner.nextInt();
                        if (index >= 0 && index < songCount) {
                            stats[0][index] += 1;
                            stats[1][index] += durations[index];
                            System.out.println("Now Playing: " + titles[index]);
                        } else {
                            System.out.println("Invalid song index!");
                        }
                    }
                    printStats();
                    break;
                case 3:
                    System.out.println("\n[TOTAL PLAYLIST TIME]");
                    if (songCount > 0) {
                        int total = calculateTotalTime(durations, songCount - 1);
                        System.out.println("Total playlist duration: " + total + " seconds.");
                    } else {
                        System.out.println("Playlist is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting system. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

