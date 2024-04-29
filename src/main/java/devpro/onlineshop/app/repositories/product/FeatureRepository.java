package devpro.onlineshop.app.repositories.product;

import devpro.onlineshop.app.entities.product.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
