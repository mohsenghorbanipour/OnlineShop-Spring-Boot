package devpro.onlineshop.app.services.product;

import devpro.onlineshop.app.entities.product.Feature;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.product.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository repository;

    public Feature getById(long Id) {
        Optional<Feature> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Feature add(Feature data) {
        return repository.save(data);
    }

    public Feature update(Feature data) throws DataNotFoundException {
        Feature oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setValue(data.getValue());
        oldDate.setKey(data.getKey());

        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Feature oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }
}
