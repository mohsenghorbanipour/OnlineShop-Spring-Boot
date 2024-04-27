package devpro.onlineshop.app.repositories.product;

import devpro.onlineshop.app.entities.product.Size;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends PagingAndSortingRepository<Size, Long> {
}
