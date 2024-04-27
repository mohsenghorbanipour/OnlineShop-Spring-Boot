package devpro.onlineshop.app.repositories.product;

import devpro.onlineshop.app.entities.product.Color;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends PagingAndSortingRepository<Color, Long> {
}
