package callmanagement;


public class Users {
    private long id;
    private String Username;
    private String Password;
    
    public long getIDs() {
        return id;
    }
    public void setIDs(long ID) {
        this.id=ID;
    }
    
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        this.Username=username;
    }
    
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password=password;
    }
}
