package entrance;

import java.util.Scanner;

public class UserProfile {
    private User userCredentials;
    public Scanner scanner = new Scanner(System.in);

    public UserProfile(User userCredentials) {
        this.userCredentials = userCredentials;
    }

    public void updateBio() {
        System.out.println("Your current bio: " + userCredentials.getBio());
        System.out.print("Enter your new bio: ");
        String newBio = scanner.nextLine();

        userCredentials.setBio(newBio);

        System.out.println("Your bio has been successfully updated.");
    }
}