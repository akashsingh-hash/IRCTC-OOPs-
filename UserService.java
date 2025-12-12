import java.util.Map;
import java.util.HashMap;

public class UserService {
    //  we have to have user details map which user which details and other 
    //  UserName --- Map 

    private Map<String,User> userMap = new HashMap<>();

    //  current user 
    private User currentUser = null;

    public boolean registerUser(String username,String password,String fullName,String contact){
        //  check whether this userName is already registered 
        if(userMap.containsKey(username)){
            System.out.println("Username already taken,Please choose another");
            return false;
        }
        User user = new User(username,password,fullName,contact);
        userMap.put(username,user);
        System.out.println("Registration Successfull");
        return true;
    }

    //  login User 
    public boolean loginUser(String userName,String password){
        if(!userMap.containsKey(userName)){
            //  user doesn't exist 
            System.out.println("No User Found tith this UserName");
            return false;
        }
        User user = userMap.get(userName);
        if(!user.getPassword().equals(password)){
            //  matching doesn't occur 
            System.out.println("Incorrect Password .. ");
            return false;
        }
        this.currentUser = user;
        System.out.println("Welcome : " + currentUser.getFullName() + "!");
        return true;
    }

    public void logOut(){
        if(currentUser!=null){
            System.out.println("Logged Out. " + currentUser.getFullName());
            currentUser = null;
        }
    }

    public User getCurrentUSer(){
        return currentUser;
    }

    public boolean isLoggedIn(){
        return currentUser != null;
    }
}
