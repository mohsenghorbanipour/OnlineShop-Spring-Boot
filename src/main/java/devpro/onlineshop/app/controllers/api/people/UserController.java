package devpro.onlineshop.app.controllers.api.people;

import devpro.onlineshop.app.entities.people.User;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ServiceResponse<User> login(@RequestBody User user) {
        User userData = service.auth(
                user.getUsername(),
                user.getPassword()
        );
        if(userData == null) {
            return new ServiceResponse<User>(
                    ResponseStatus.FAILED,
                    "Incorrect Username Or Password"
            );
        } else {
            new ServiceResponse<User>(
                    ResponseStatus.SUCCESS,
                    userData
            );
        }
    }

}
