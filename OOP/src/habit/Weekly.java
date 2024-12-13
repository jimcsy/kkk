package habit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utils.Design;

import java.util.Iterator;

public class Weekly extends Habit {
    public void createHabit(String tag) {
        Design.sub(6);
        System.out.println("Today is: " + today.format(day));

        System.out.print("Enter the name of the Habit: \t\t");
        this.habitName = scanner.nextLine();

        if(habitName.isEmpty()){
            System.out.print("Name cannot be empty. \t\t");
            Design.delay(1500);
            return;
        }

        System.out.print("Enter a description for the habit: \t");
        this.habitDescription = scanner.nextLine();

        this.habitGoal = "";

        List<Integer> selectedDays = new ArrayList<>();
        System.out.println("Select days of the week (1-7, where 1=Monday, 7=Sunday). Enter 0 when done.");

        while (true) {
            System.out.print("Enter a day (1-7 or 0 to finish): \t");
            int day = -1;

            try {
                day = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                continue;
            }

            if (day == 0) {
                break;
            } else if (day >= 1 && day <= 7) {
                if (!selectedDays.contains(day)) {
                    selectedDays.add(day);
                } else {
                    System.out.println("You have already selected this day.");
                }
            } else {
                System.out.println("Invalid day! Please enter a number between 1 and 7.");
            }
        }

        StringBuilder daysInitials = new StringBuilder();
        for (int day : selectedDays) {
            switch (day) {
                case 1:
                    daysInitials.append("M"); // Monday
                    break;
                case 2:
                    daysInitials.append("T"); // Tuesday
                    break;
                case 3:
                    daysInitials.append("W"); // Wednesday
                    break;
                case 4:
                    daysInitials.append("Th"); // Thursday
                    break;
                case 5:
                    daysInitials.append("F"); // Friday
                    break;
                case 6:
                    daysInitials.append("Sat"); // Saturday
                    break;
                case 7:
                    daysInitials.append("S"); // Sunday
                    break;
                default:
                    break;
            }
            daysInitials.append(",");
        }

        if (daysInitials.length() > 0) {
            daysInitials.setLength(daysInitials.length() - 1);
        }

        this.habitGoal = daysInitials.toString();

        System.out.println("Habit goal set for days: " + habitGoal);

        addHabit(habitName, habitDescription, "0", habitGoal, tag);  
        System.out.println("Successfully created habit \"" + habitName + "\" as a weekly habit!");
        Design.delay(1500);
    }

    public boolean printHabits(int type, int indicator) {
        Design.sub(8);
        System.out.println("Habits created: ");
        
        Iterator<String> iterator = habits.keySet().iterator(); 
        
        if (!iterator.hasNext()) {
            System.out.println("No habits found.");
            return false;
        }
    
        int n = 1;
        while (iterator.hasNext()) {
            String habitName = iterator.next();
            String[] habitDetails = habits.get(habitName); 
    
            String description = habitDetails[0];
            String status = habitDetails[1];
            String goal = habitDetails[2]; 
            String frequency = habitDetails[3];
    
            if (goal.matches("^(?:(M|T|W|Th|F|Sat|S)(?:,?\\s?))*$")) {  
                if (indicator == 0 && "Completed".equals(status)) {
                    continue; 
                }
    
                System.out.println(n + ". Name:\t " + habitName);
                System.out.println("   Description:\t " + description);
                System.out.println("   Status:\t " + status);
                System.out.println("   Goal: \t" + goal); 
                System.out.println("   Frequency: \t" + frequency);
                n++;
            }
        }
        return true;
    }
    

    public void updateStatus(int indicator) {
        if(printHabits(0, 0)){
   
            System.out.print("Enter the name of the habit you want to update: ");
            
            String habitToEdit = scanner.nextLine();
            
            if (habits.containsKey(habitToEdit)) {
                String[] habitDetails = habits.get(habitToEdit);
                String goal = habitDetails[2]; 
                

                String currentDay = LocalDate.now().getDayOfWeek().toString().substring(0, 1); 
        
         
                if (indicator == 0) {
                    habitDetails[1] = "0"; 
                    System.out.println("\nThe status has been reset to 0.");
                    return;
                }
        
                if (goal.contains(currentDay)) {
                    System.out.println("\nToday is a valid day for updating your habit.");
                    
                 
                    int statusNum = 0;
                    try {
                        statusNum = Integer.parseInt(habitDetails[1]); 
                    } catch (NumberFormatException e) {
                        if ("Completed".equals(habitDetails[1])) {
                            System.out.println("\nThis habit is already marked as 'Completed'.");
                            return;
                        }
                    }
        
                    int goalNum = goal.split(",").length;  
                    if (goalNum > 7) {
                        goalNum = 7;  
                    }
        
                    if (statusNum < goalNum && statusNum < 7) {
                        statusNum++; 
                        habitDetails[1] = Integer.toString(statusNum);  
                        System.out.println("Updated status: " + statusNum + "/" + goalNum);
        
                        if (statusNum == goalNum) {
                            habitDetails[1] = "Completed";
                            System.out.println("Goal reached! Status marked as 'Completed'.");
                        }
                    } else if (statusNum == 7) {
                        System.out.println("You have already reached the maximum possible status (7 days).");
                    }
                    System.out.println("Successful update!");

                    System.out.println("Press [Enter] to continue...");
                    scanner.nextLine();
                } else {
                    System.out.println("Today is not a valid day for updating this habit. It can only be updated on: " + goal);
                }
            } else {
                System.out.println("Failed! Habit not found.");
            }
        } 
    }

    public void deleteHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits to delete. The list is empty.");
            return;  
        }
        Design.sub(8);
        System.out.println("Here are all your weekly habits with their current status:");
        for (Map.Entry<String, String[]> entry : habits.entrySet()) {
            String habitName = entry.getKey();
            String[] habitDetails = entry.getValue();

            String status = habitDetails[1];
            String statusMessage;

        
            switch (status) {
                case "0":
                    statusMessage = "not yet started";
                    break;
                case "Completed":
                    statusMessage = "complete";
                    break;
                default:
                    statusMessage = "in progress";
                    break;
            }

            System.out.println("Name: " + habitName + " - Status: " + statusMessage);
        }

        System.out.print("\nEnter the name of the habit you want to delete: ");
        String habitToDelete = scanner.nextLine();

        if (habits.containsKey(habitToDelete)) {
            System.out.print("Are you sure you want to delete the habit \"" + habitToDelete + "\"? (y/n): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("y")) {
                habits.remove(habitToDelete);
                System.out.println("Habit \"" + habitToDelete + "\" has been deleted successfully.");
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Habit not found. Please check the name and try again.");
        }
    }
}

