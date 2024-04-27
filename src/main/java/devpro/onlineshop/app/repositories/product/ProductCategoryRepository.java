package devpro.onlineshop.app.repositories.product;

import devpro.onlineshop.app.entities.site.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<Blog, Long> {
}
