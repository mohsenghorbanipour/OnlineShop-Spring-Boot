package devpro.onlineshop.app.services.orders;

import devpro.onlineshop.app.entities.orders.OrderItem;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.orders.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public OrderItem getById(long Id) {
        Optional<OrderItem> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public OrderItem add(OrderItem data) {
        return repository.save(data);
    }

    public OrderItem update(OrderItem data) throws DataNotFoundException {
        OrderItem oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setCount(data.getCount());
        oldDate.setPrice(data.getPrice());

        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        OrderItem oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }


}
