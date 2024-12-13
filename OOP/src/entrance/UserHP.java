package entrance;

import java.util.Scanner;
import habit.HabitMenu;
import utils.Design;

public class UserHP extends User {
    public Scanner scanner = new Scanner(System.in);

    public UserHP(String username, String password, String bio) {
        super(username, password, bio);
    }

    public void userMenu(User profile) {
        while (true) {
            Design.clearScreen();
            Design.header();
            System.out.println("GOOD DAY, " + getUsername().toUpperCase() + "!");
            System.out.println("Bio: " + getBio());
            Design.sub(5);
            
            System.out.println("1. Habits");
            System.out.println("2. Change Bio");
            System.out.println("3. Logout");
            System.out.print("\nWhat would you like to do? ");
            int ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    HabitMenu access = new HabitMenu();
                    access.habitMenu();
                    break;
                case 2:
                    Design.sub(5);
                    UserProfile update = new UserProfile(profile);
                    update.updateBio();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}