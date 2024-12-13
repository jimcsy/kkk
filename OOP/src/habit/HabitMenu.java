package habit;


import java.util.Scanner;
import utils.Design;

public class HabitMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private final Habit weekly = new Weekly();
    private final Habit daily = new Daily();

    public void habitMenu() {
        while (true) {
            printMainMenu();
            int choice = getUserChoice(1, 6);
            
            Design.clearScreen();
            Design.header();
            switch (choice) {
                case 1:
                    createNewHabit();
                    break;
                case 2:
                    updateHabitStatus();
                    Design.delay(1500);
                    break;
                case 3:
                    resetHabitProgress();
                    Design.delay(1500);
                    break;
                case 4:
                    deleteHabit();
                    Design.delay(1500);
                    break;
                case 5:
                    viewExistingHabits();
                    Design.delay(1500);
                    break;
                case 6:
                    System.out.println("Exiting application...");
                    Design.delay(1500);
                    return;
                default:
                    System.out.println("\nInvalid choice, try again.");
            }
        }
    }

    private void printMainMenu() {
        Design.clearScreen();
        Design.header();
        Design.sub(4);
        System.out.println("1. Create a New Habit");
        System.out.println("2. Update Habit Status");
        System.out.println("3. Reset Habit Progress");
        System.out.println("4. Delete a Habit");
        System.out.println("5. View Existing Habits");
        System.out.println("6. Exit Application");
        System.out.print("\nEnter your choice (1-6): ");
    }

    private int getUserChoice(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt(); 
                scanner.nextLine();  

                if (choice >= min && choice <= max) {
                    return choice; 
                } else {
                    System.out.print("Invalid choice, please try again: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input, please enter a number: ");
                scanner.nextLine(); 
            }
        }
    }

    private void createNewHabit() {
        Design.sub(4);
        System.out.print("Select frequency? \n1. Daily \n2. Weekly \nChoose Frequency: ");
        String frequency = scanner.nextLine();

        if (frequency.equals("1")) {
            daily.createHabit("Daily");
        } else if (frequency.equals("2")) {
            weekly.createHabit("Weekly");
        } else {
            System.out.println("Invalid frequency, please choose either 1 or 2.");
            Design.delay(1500);
        }
    }

    private void updateHabitStatus() {
        Design.sub(4);
        System.out.println("From what frequency do you want to update?");
        System.out.println("1. Daily Habits");
        System.out.print("2. Weekly Habits \nChoose: ");
        
        int choice = getUserChoice(1, 2);

        if (choice == 1) {
            daily.updateStatus(1); 
        } else if (choice == 2) {
            weekly.updateStatus(1);
        }
    }

    private void resetHabitProgress() {
        Design.sub(4);
        System.out.println("From what frequency do you want to reset?");
        System.out.println("1. Daily Habits");
        System.out.print("2. Weekly Habits \nChoose: ");
        
        int choice = getUserChoice(1, 2);

        if (choice == 1) {
            daily.updateStatus(0); 
        } else if (choice == 2) {
            weekly.updateStatus(0); 
        }
    }

    private void deleteHabit() {
        Design.sub(4);
        System.out.println("From what frequency do you want to delete?");
        System.out.println("1. Daily Habits");
        System.out.print("2. Weekly Habits \nChoose: ");
        
        int choice = getUserChoice(1, 2);

        if (choice == 1) {
            daily.deleteHabits();
        } else if (choice == 2) {
            weekly.deleteHabits();
        }
    }

    private void viewExistingHabits() {
        Design.sub(4);
        System.out.println("Which habits do you want to see?");
        System.out.println("1. All");
        System.out.println("2. Daily Habits");
        System.out.println("3. Weekly Habits");
        System.out.print("4. Back to Main Menu \nChoose: ");
        
        int choice = getUserChoice(1, 4);

        switch (choice) {
            case 1:
                daily.printHabits(1, 1);
                weekly.printHabits(0, 0);
                break;
            case 2:
                daily.printHabits(1, 1);
                break;
            case 3:
                weekly.printHabits(0, 0);
                break;
            case 4:
                break;
        }
    }
}
