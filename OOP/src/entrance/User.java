package entrance;

public class User {
    private String password, bio, username;

    public User(String password, String bio) {
        this.password = password;
        this.bio = bio;
    }

    public User(String username, String password, String bio) {
        this.password = password;
        this.bio = bio;
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getUsername(){
        return username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


}