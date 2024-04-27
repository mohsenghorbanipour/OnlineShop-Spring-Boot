package devpro.onlineshop.app.repositories.people;

import devpro.onlineshop.app.entities.people.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
