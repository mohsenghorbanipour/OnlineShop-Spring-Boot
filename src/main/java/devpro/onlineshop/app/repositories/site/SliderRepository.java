package devpro.onlineshop.app.repositories.site;

import devpro.onlineshop.app.entities.site.Slider;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SliderRepository extends JpaRepository<Slider, Long> {

    List<Slider> findAllByEnableIsTrue(Sort sort);
}
