import java.util.Scanner;


public class WEEK2_PlaylistManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Song Registration Shell ===");

        System.out.print("Enter Song Title: ");
        String songName = scanner.nextLine();

        System.out.print("Enter Music Genre: ");
        String genre = scanner.next();

        System.out.print("Enter Duration in Seconds: ");
        int duration = scanner.nextInt();

        System.out.print("Enter Track Rating (1.0 to 5.0): ");
        double rating = scanner.nextDouble();

        System.out.println("\n--- Song Registration Summary ---");
        System.out.println("Title: " + songName);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " seconds");
        System.out.println("Rating: " + rating + " / 5.0");

        scanner.close();
    }
}



