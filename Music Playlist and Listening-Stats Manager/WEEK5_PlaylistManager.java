public class WEEK5_PlaylistManager {

    // Method to calculate remaining queue time
    public static int subtractTime(int totalTime, int songLength) {
        if (songLength > totalTime) {
            System.out.println("Error: Not enough time remaining in queue!");
            return totalTime;
        }
        System.out.println("Song added successfully.");
        return totalTime - songLength;
    }

    // Recursive function to calculate time projection
    public static int calculateProjection(int baseTime, int levels) {
        if (levels <= 1) {
            return baseTime;
        }
        return baseTime + calculateProjection(baseTime / 2, levels - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Methods and Recursion ===");

        int queueTime = 3000;
        queueTime = subtractTime(queueTime, 354);
        System.out.println("Remaining Queue Time: " + queueTime + " seconds.");

        System.out.println("\n--- Recursive Calculation ---");
        int projectedTime = calculateProjection(300, 3);
        System.out.println("Projected Playback Duration: " + projectedTime + " seconds.");
    }
}


