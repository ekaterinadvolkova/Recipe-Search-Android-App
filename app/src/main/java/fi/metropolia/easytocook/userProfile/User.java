package fi.metropolia.easytocook.userProfile;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String passwords;


    public User(String firstName, String lastName, String userName, String email, String passwords){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.passwords = passwords;
    }

    public String toString (){
        return this.firstName + " " +this.lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswords(){
        return passwords;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
