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

//    public List<Product> search(String search) {
////        return repository.findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(search);
//    }

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
        oldDate.setTitle(data.getTitle());
        oldDate.setEnable(data.isEnable());
        oldDate.setImage(data.getImage());
        oldDate.setDescription(data.getDescription());
        oldDate.setExist(data.isExist());
        oldDate.setPrice(data.getPrice());
        oldDate.setColors(data.getColors());
        oldDate.setCategory(data.getCategory());
        oldDate.setFeatures(data.getFeatures());
        oldDate.setSizes(data.getSizes());
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
