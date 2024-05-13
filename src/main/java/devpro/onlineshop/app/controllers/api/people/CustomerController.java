package devpro.onlineshop.app.controllers.api.people;

import devpro.onlineshop.app.entities.people.Customer;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.people.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    public ServiceResponse<Customer> getById(@PathVariable long id) {
        try {
            Customer result = service.getById(id);
            return new ServiceResponse<Customer>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Customer>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Customer> add(@RequestBody Customer data) {
        try {
            Customer result = service.add(data);
            return new ServiceResponse<Customer>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Customer>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Customer> update(@RequestBody Customer data) {
        try {
            Customer result = service.update(data);
            return new ServiceResponse<Customer>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Customer>(
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
