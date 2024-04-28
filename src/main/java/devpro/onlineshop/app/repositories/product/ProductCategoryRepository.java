package devpro.onlineshop.app.repositories.product;

import devpro.onlineshop.app.entities.product.ProductCategory;
import devpro.onlineshop.app.entities.site.Blog;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {

    List<ProductCategory> findAllByEnableIsTrue(Sort sort);

}
