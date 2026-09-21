

    import java.util.Scanner;

public class WEEK3_PlaylistManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Song Eligibility Check ===");

        System.out.print("Enter Song Duration (seconds): ");
        int duration = scanner.nextInt();

        if (duration >= 60) {
            if (duration <= 600) {
                System.out.print("Enter Song Rating (1.0 to 5.0): ");
                double rating = scanner.nextDouble();

                if (rating >= 3.0) {
                    System.out.println("Status: Approved for Featured Playlist!");
                } else {
                    System.out.println("Status: Rejected. Rating must be at least 3.0.");
                }
            } else {
                System.out.println("Status: Rejected. Song length is too long (Max 600s).");
            }
        } else {
            System.out.println("Status: Rejected. Song must be at least 60 seconds long.");
        }

        System.out.print("\nEnter Genre Name (POP / ROCK / JAZZ): ");
        String genre = scanner.next().toUpperCase();

        System.out.print("Rules for " + genre + ": ");
        switch (genre) {
            case "POP":
                System.out.println("Radio edit format (3 to 4 mins).");
                break;
            case "ROCK":
                System.out.println("Instrumental solos allowed.");
                break;
            case "JAZZ":
                System.out.println("Acoustic mix active.");
                break;
            default:
                System.out.println("Standard audio rules apply.");
                break;
        }
        scanner.close();
    }
}
