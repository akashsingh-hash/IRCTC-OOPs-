public class User {
    private String userName;
    private String password;

    private String fullName;
    private String contact;

    public User(String userName,String password,String fullName,String contact){
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.contact = contact;
    }

    //  getter and setter here
    String getUserName(){
        return userName;
    } 

    void setUserName(String userName){
        this.userName = userName;
    }
    //  passwrod 
    String getPassword(){
        return password;
    }
    void setPassword(String password){
        this.password = password;
    }
    //  fullName 
    String getFullName(){
        return fullName;
    }
    void setFullName(String fullName){
        this.fullName = fullName;
    }
    // contact
    String getContact(){
        return contact;
    }
    void setContact(String contact){
        this.contact = contact;
    }
    //  to string method 

    @Override 
    public String toString(){
        return "UserName : " + userName + " | fullName : " + fullName + " | Contact : " + contact;
    }
}
