package utils;

import java.util.HashMap;

public class Databases {
    private HashMap<String, String[]> userDatabase = new HashMap<>();
    public HashMap<String, String[]> habits = new HashMap<>();

    //getter
    public HashMap<String, String[]> getHabitsMap() {
        return habits;  
    }

    public void addUser(String username, String password, String bio) {
        userDatabase.put(username, new String[] {password, bio});
    }

    public void addHabit(String habitName, String description, String status , String goal, String tag) {
        habits.put(habitName, new String[] {description, status, goal, tag});
    }

    public boolean usernameExists(String username) {
        return userDatabase.containsKey(username);
    }

    public String getCredentials(String username, int index) {
        if (userDatabase.containsKey(username)) {
            return userDatabase.get(username)[index]; 
        }
        return null;
    }

    public String getHabitValue(String key, int index) {
        if (habits.containsKey(key)) {
            return habits.get(key)[index]; 
        }
        return null;
    }

    public String getBio(String username) {
        if (userDatabase.containsKey(username)) {
            return userDatabase.get(username)[1]; 
        }
        return null;
    }
}
