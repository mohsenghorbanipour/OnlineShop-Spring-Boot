package devpro.onlineshop.app.services.product;
import devpro.onlineshop.app.entities.product.ProductCategory;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.product.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    public List<ProductCategory> findAllByEnableIsTrue() {
        return  repository.findAllByEnableIsTrue(Sort.by("id"));
    }

    public ProductCategory getById(long Id) {
        Optional<ProductCategory> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public ProductCategory add(ProductCategory data) {
        return repository.save(data);
    }

    public ProductCategory update(ProductCategory data) throws DataNotFoundException {
        ProductCategory oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setTitle(data.getTitle());
        oldDate.setEnable(data.isEnable());
        oldDate.setImage(data.getImage());
        oldDate.setDescription(data.getDescription());

        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        ProductCategory oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }
}
