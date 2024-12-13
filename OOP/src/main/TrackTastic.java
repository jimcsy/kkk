package main;

import java.util.Scanner;

import entrance.Register;
import utils.Design;

public class TrackTastic {
    public static Scanner scanner = new Scanner(System.in);
    public static Register user = new Register();

    public static void main(String[] args) {
        while (true) {
            Design.clearScreen();
            Design.header();
        
            displayMenu();
        
            String ch = scanner.nextLine();
            
            if (!isValidChoice(ch)) {
                System.out.println("Invalid choice... Please try again.");
                continue;
            }

            switch (ch) {
                case "1":
                    user.register();
                    break;
                case "2":
                    user.login();
                    break;
                case "3":
                    System.out.println("Exiting the program... Thank you for using TrackTastic!");
                    return; 
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Register");
        System.out.println("2. Log In");
        System.out.println("3. Exit");
        System.out.print("\nSelect from the list: \t");
    }
    
    private static boolean isValidChoice(String choice) {
        return choice.equals("1") || choice.equals("2") || choice.equals("3");
    }
}
