package devpro.onlineshop.app.services.people;

import devpro.onlineshop.app.entities.people.Customer;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.people.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer getById(long Id) {
        Optional<Customer> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Customer add(Customer data) {
        return repository.save(data);
    }

    public Customer update(Customer data) throws DataNotFoundException {
        Customer oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setEmail(data.getEmail());
        oldDate.setAddress(data.getAddress());
        oldDate.setFirstName(data.getFirstName());
        oldDate.setLastName(data.getLastName());
        oldDate.setMobile(data.getMobile());
        oldDate.setPostalCode(data.getPostalCode());
        oldDate.setTel(data.getTel());


        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Customer oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }


}
