package entrance;

import java.util.Scanner;

import utils.*;

public class Register {
    public Databases credentials = new Databases();
    public Scanner scanner = new Scanner(System.in);

    public void register() {
        while (true) {
            Design.clearScreen();
            Design.sub(1);
            System.out.print("Enter new username (at least 6 characters): \t");
            String username = scanner.nextLine();


            if (username.isEmpty()) {
                System.out.println("Username is empty. Returning to home page...");
                Design.delay(1500);
                return;  
            }

            if (username.length() < 6) { 
                System.out.println("\nUsername must be at least 6 characters long. Please try again.");
                Design.delay(1500);
                continue;
            }

            if (credentials.usernameExists(username)) {
                System.out.println("\nUsername already exists. Please try again.");
                Design.delay(1500);
                continue;
            }

            System.out.print("Enter your password (at least 8 characters): \t");
            String password = scanner.nextLine();


            if (password.isEmpty()) {
                System.out.println("Password is empty. Returning to home page...");
                Design.delay(1500);
                return;  
            }

            if (password.length() < 8) {
                System.out.println("\nPassword must be at least 8 characters long. Please try again.");
                Design.delay(1500);
                continue;
            }


            System.out.print("Enter your bio: \t");
            String bio = scanner.nextLine();

    
            credentials.addUser(username, password, bio);

            System.out.println("\nRegistration successful. Please log-in!");
            Design.delay(1500);
            break;  
        }
    }

    public boolean login() {
        while (true) {
            Design.clearScreen();
            Design.sub(2);
            System.out.print("Enter username: \t");
            String username = scanner.nextLine();


            if (username.isEmpty()) {
                System.out.println("Username is empty. Returning to home page...");
                Design.delay(1500);
                return false;  
            }

            if (!credentials.usernameExists(username)) {
                System.out.println("\nUsername does not exist. Try again...");
                Design.delay(1500);
                return false; 
            }

            System.out.print("Enter your password: \t");
            String enteredPassword = scanner.nextLine();

 
            if (enteredPassword.isEmpty()) {
                System.out.println("Password is empty. Returning to home page...");
                Design.delay(1500);
                return false;  
            }

            String storedPassword = credentials.getCredentials(username, 0);

            if (storedPassword != null && storedPassword.equals(enteredPassword)) {
                System.out.println("\nLogin successful.");
                Design.delay(1500);
                UserHP homepage = new UserHP(username, enteredPassword, credentials.getBio(username));
                homepage.userMenu(homepage);  
                return true;
            } else {
                System.out.println("\nIncorrect password. Try again...");
                Design.delay(1500);
                return false;
            }
        }
    }
}
