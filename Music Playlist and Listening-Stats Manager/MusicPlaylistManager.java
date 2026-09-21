import java.util.Scanner;

public class MusicPlaylistManager {

    // Global constant for array limits
    private static final int MAX_SONGS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- CO1: Data Representation (1D Arrays & Primitive Types) ---
        String[] songTitles = new String[MAX_SONGS];
        int[] songDurations = new int[MAX_SONGS]; // in seconds
        int songCount = 0;

        // --- CO3: Data Representation (2D Array for Listening Stats) ---
        // Row 0 = Play Counts, Row 1 = Total Listening Time (seconds)
        int[][] listeningStats = new int[2][MAX_SONGS];

        System.out.println("=== MUSIC PLAYLIST & LISTENING STATS MANAGER ===");

        // Pre-populating some initial songs
        songTitles[0] = "Bohemian Rhapsody";
        songDurations[0] = 354;
        songCount++;

        songTitles[1] = "Hotel California";
        songDurations[1] = 390;
        songCount++;

        // --- CO2: Control Flow (Iteration via do-while & selection via switch) ---
        boolean exit = false;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    // CO1: Sequential Console I/O & Array Operations
                    if (songCount < MAX_SONGS) {
                        System.out.print("Enter song title: ");
                        songTitles[songCount] = scanner.nextLine();
                        System.out.print("Enter duration in seconds: ");
                        songDurations[songCount] = scanner.nextInt();
                        songCount++;
                        System.out.println("Song added successfully!");
                    } else {
                        System.out.println("Error: Playlist is full!");
                    }
                    break;

                case 2:
                    // CO3: Modularized via Method
                    displayPlaylist(songTitles, songDurations, songCount);
                    break;

                case 3:
                    // CO2 & CO3: Simulating listening & updating 2D stats array
                    displayPlaylist(songTitles, songDurations, songCount);
                    if (songCount > 0) {
                        System.out.print("Enter song index to listen to (0 to " + (songCount - 1) + "): ");
                        int index = scanner.nextInt();
                        
                        // CO2: Selection Validation
                        if (index >= 0 && index < songCount) {
                            listeningStats[0][index] += 1; // Increment Play Count
                            listeningStats[1][index] += songDurations[index]; // Accumulate Total Time
                            System.out.println("Played: " + songTitles[index]);
                        } else {
                            System.out.println("Invalid song index!");
                        }
                    }
                    break;

                case 4:
                    // CO3: Processing 2D Array
                    displayStats(songTitles, listeningStats, songCount);
                    break;

                case 5:
                    // CO3: Recursion Example
                    if (songCount > 0) {
                        int totalDuration = calculateTotalDurationRecursive(songDurations, songCount - 1);
                        System.out.println("Total Playlist Duration (Recursive Calculation): " 
                                + totalDuration + " seconds (" + (totalDuration / 60) + " mins)");
                    } else {
                        System.out.println("Playlist is empty.");
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println();
        } while (!exit);

        scanner.close();
    }

    // --- CO3: Helper Methods ---

    // Display Playlist (Iterates over 1D Arrays)
    private static void displayPlaylist(String[] titles, int[] durations, int count) {
        if (count == 0) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("\n--- Current Playlist ---");
        for (int i = 0; i < count; i++) {
            System.out.println("[" + i + "] " + titles[i] + " (" + durations[i] + "s)");
        }
    }

    // Display Stats (Iterates over 2D Array)
    private static void displayStats(String[] titles, int[][] stats, int count) {
        if (count == 0) {
            System.out.println("No stats available.");
            return;
        }
        System.out.println("\n--- Listening Statistics ---");
        for (int j = 0; j < count; j++) {
            int playCount = stats[0][j];
            int totalTime = stats[1][j];
            System.out.println(titles[j] + " -> Played: " + playCount + " times | Total Time Listened: " + totalTime + "s");
        }
    }

    // Recursively sum up array values (Base Case: index < 0)
    private static int calculateTotalDurationRecursive(int[] durations, int index) {
        // Base case: Terminate recursion when index goes past array boundary
        if (index < 0) {
            return 0;
        }
        // Recursive step
        return durations[index] + calculateTotalDurationRecursive(durations, index - 1);
    }

    private static void printMenu() {
        System.out.println("------------------------------------");
        System.out.println("1. Add Song to Playlist");
        System.out.println("2. View Playlist");
        System.out.println("3. Listen to a Song");
        System.out.println("4. View Listening Stats");
        System.out.println("5. Calculate Total Playlist Duration (Recursive)");
        System.out.println("6. Exit");
        System.out.println("------------------------------------");
    }
}
