package devpro.onlineshop.app.repositories.people;

import devpro.onlineshop.app.entities.people.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUsernameAndPassword(String username, String password);

}
