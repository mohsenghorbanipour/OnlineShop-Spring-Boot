package devpro.onlineshop.app.helper.uimodel.people;

import devpro.onlineshop.app.entities.people.User;
import devpro.onlineshop.app.enums.UserRole;

public class UserViewModel {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private UserRole role;
    private boolean enable;
    private String token;

    public UserViewModel() {
    }

    public UserViewModel(User user) {
        setId(user.getId());
        setEmail(user.getEmail());
        setEnable(user.isEnable());
        setUsername(user.getUsername());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setRole(user.getRole());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
