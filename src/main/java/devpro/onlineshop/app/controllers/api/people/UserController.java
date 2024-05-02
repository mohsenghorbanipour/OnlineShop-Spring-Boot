package devpro.onlineshop.app.controllers.api.people;

import devpro.onlineshop.app.entities.people.User;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.helper.uimodel.people.UserViewModel;
import devpro.onlineshop.app.services.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ServiceResponse<UserViewModel> login(@RequestBody User user) {
        User userData = service.auth(
                user.getUsername(),
                user.getPassword()
        );
        if(userData == null) {
            return new ServiceResponse<UserViewModel>(
                    ResponseStatus.FAILED,
                    "Incorrect Username Or Password"
            );
        } else {
            UserViewModel userVM = new UserViewModel(
                    userData
            );
            userVM.setToken("--------");
            return new ServiceResponse<UserViewModel>(
                    ResponseStatus.SUCCESS,
                    userVM
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<User> getById(@PathVariable long id) {
        try {
            User result = service.getById(id);
            return new ServiceResponse<User>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<User>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<User> add(@RequestBody User data) {
        try {
            User result = service.add(data);
            return new ServiceResponse<User>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<User>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<User> update(@RequestBody User data) {
        try {
            User result = service.update(data);
            return new ServiceResponse<User>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<User>(
                    e
            );
        }
    }

    @DeleteMapping("/{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean result = service.deleteById(id);
            return new ServiceResponse<Boolean>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Boolean>(
                    e
            );
        }
    }

}
