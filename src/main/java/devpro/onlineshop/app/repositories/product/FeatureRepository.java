package devpro.onlineshop.app.repositories.product;

import devpro.onlineshop.app.entities.product.Feature;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends PagingAndSortingRepository<Feature, Long> {
}
