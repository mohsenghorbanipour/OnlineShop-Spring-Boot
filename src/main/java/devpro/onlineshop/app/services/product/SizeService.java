package devpro.onlineshop.app.services.product;

import devpro.onlineshop.app.entities.product.Size;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.product.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SizeService {

    @Autowired
    private SizeRepository repository;

    public Size getById(long Id) {
        Optional<Size> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Size add(Size data) {
        return repository.save(data);
    }

    public Size update(Size data) throws DataNotFoundException {
        Size oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setTitle(data.getTitle());
        oldDate.setDescription(data.getDescription());

        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Size oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }
}
