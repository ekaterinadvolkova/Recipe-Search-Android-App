package fi.metropolia.easytocook.userProfile;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {

    ////singleton class and assigned the userAccount object into userAccountInstance;
    private static final UserAccount userAccountInstance = new UserAccount();

    public static UserAccount getInstance(){
        return userAccountInstance;
    }

    private List<User> users; //initialize the instance variable

    private UserAccount(){
        this.users = new ArrayList<>();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers (){
        return this.users;
    }

    public User getUser(int indexOfAUser){
        return this.users.get(indexOfAUser);
    }

    public void addUser(User user){
        this.users.add(user);
    }

}
