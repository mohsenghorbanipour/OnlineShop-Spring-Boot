package devpro.onlineshop.app.repositories.people;

import devpro.onlineshop.app.entities.people.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
