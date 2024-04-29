package devpro.onlineshop.app.services.orders;

import devpro.onlineshop.app.entities.orders.Invoice;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.orders.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    public List<Invoice> findAllByCustomer(long customerId) {
        return  repository.findAllByCustomer(customerId);
    }

    public Invoice getById(long Id) {
        Optional<Invoice> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Invoice add(Invoice data) {
        return repository.save(data);
    }

    public Invoice update(Invoice data) throws DataNotFoundException {
        Invoice oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setPayedDate(data.getPayedDate());

        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Invoice oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }


}
