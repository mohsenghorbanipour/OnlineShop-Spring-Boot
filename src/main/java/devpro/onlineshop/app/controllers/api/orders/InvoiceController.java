package devpro.onlineshop.app.controllers.api.orders;

import devpro.onlineshop.app.entities.orders.Invoice;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.orders.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;



    @GetMapping("/find")
    public ServiceResponse<Invoice> findAllByCustomerId(@RequestParam long id) {
        try {
            List<Invoice> result = service.findAllByCustomer(id);
            return new ServiceResponse<Invoice>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Invoice>(
                    e
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Invoice> getById(@PathVariable long id) {
        try {
            Invoice result = service.getById(id);
            return new ServiceResponse<Invoice>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Invoice>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Invoice> add(@RequestBody Invoice data) {
        try {
            Invoice result = service.add(data);
            return new ServiceResponse<Invoice>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Invoice>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Invoice> update(@RequestBody Invoice data) {
        try {
            Invoice result = service.update(data);
            return new ServiceResponse<Invoice>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Invoice>(
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
