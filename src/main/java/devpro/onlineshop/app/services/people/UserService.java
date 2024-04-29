package devpro.onlineshop.app.services.people;

import devpro.onlineshop.app.entities.people.User;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.people.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User auth(String username, String password) {
        //TODO HASH PASSWORD
        return repository.findFirstByUsernameAndPassword(username, password);
    }

    public User getById(long Id) {
        Optional<User> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public User add(User data) {
        return repository.save(data);
    }

    public User update(User data) throws DataNotFoundException {
        User oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setEmail(data.getEmail());
        oldDate.setEnable(data.isEnable());
        oldDate.setFirstName(data.getFirstName());
        oldDate.setLastName(data.getLastName());

        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        User oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }

    public User changePassword(long id, String oldPassword, String newPassword) throws Exception {
        //TODO HASH PASSWORD
        User user = getById(id);
        if(user == null) {
            throw new DataNotFoundException(
                   "user not found"
            );
        }

        if (!user.getPassword().equals(oldPassword)) {
            throw  new Exception("invalid old password");
        }

        user.setPassword(newPassword);
        return repository.save(user);
    }
}
