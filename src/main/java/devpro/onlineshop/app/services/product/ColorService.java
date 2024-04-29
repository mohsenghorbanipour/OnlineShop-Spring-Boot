package devpro.onlineshop.app.services.product;

import devpro.onlineshop.app.entities.product.Color;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.product.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository repository;

    public Color getById(long Id) {
        Optional<Color> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Color add(Color data) {
        return repository.save(data);
    }

    public Color update(Color data) throws DataNotFoundException {
        Color oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setValue(data.getValue());
        oldDate.setName(data.getName());

        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Color oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }
}
