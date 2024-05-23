package devpro.onlineshop.app.services.product;

import devpro.onlineshop.app.entities.product.Product;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<Product> findAllByCategory(long categoryId) {
        return  repository.findAllByCategory(categoryId);
    }

    public List<Product> search(String search) {
        return repository.findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(search);
    }

    public Product getById(long Id) {
        Optional<Product> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Product add(Product data) {
        return repository.save(data);
    }

    public Product update(Product data) throws DataNotFoundException {
        Product oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        if(data.getTitle() != null) {
            oldDate.setTitle(data.getTitle());
        }
        if(data.getImage() != null) {
            oldDate.setImage(data.getImage());
        }
        if(data.getDescription() != null) {
            oldDate.setDescription(data.getDescription());
        }
        if(data.getPrice() != null) {
            oldDate.setPrice(data.getPrice());
        }
        if(data.getColors() != null) {
            oldDate.setColors(data.getColors());
        }
        if(data.getCategory() != null) {
            oldDate.setCategory(data.getCategory());
        }
        if(data.getFeatures() != null) {
            oldDate.setFeatures(data.getFeatures());
        }
        if(data.getSizes() != null) {
            oldDate.setSizes(data.getSizes());
        }
        if(data.isEnable() != null) {
            oldDate.setEnable(data.isEnable());
        }
        if(data.isExist() != null) {
            oldDate.setExist(data.isExist());
        }
        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Product oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }

    public Product increaseVisitCountById(long id) throws DataNotFoundException {
        Product oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        oldDate.setVisitCount(oldDate.getVisitCount() + 1);
        return repository.save(oldDate);
    }
}
