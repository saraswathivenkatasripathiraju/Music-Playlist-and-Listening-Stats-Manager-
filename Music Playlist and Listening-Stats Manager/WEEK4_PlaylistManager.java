import java.util.Scanner;

public class WEEK4_PlaylistManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Register Song");
            System.out.println("2. Play Song");
            System.out.println("3. Run Diagnostic Check");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");
            choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting application. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("[LOG]: Registering a new song...");
                    break;
                case 2:
                    System.out.println("[LOG]: Playing selected track...");
                    break;
                case 3:
                    System.out.println("[LOG]: Running system checks...");
                    for (int i = 3; i > 0; i--) {
                        if (i == 2) {
                            System.out.println("  Skipping step 2...");
                            continue;
                        }
                        System.out.println("  Check " + i + " Passed.");
                    }
                    break;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

