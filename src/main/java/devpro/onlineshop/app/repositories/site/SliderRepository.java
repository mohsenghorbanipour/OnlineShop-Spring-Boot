package devpro.onlineshop.app.repositories.site;

import devpro.onlineshop.app.entities.site.Slider;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SliderRepository extends PagingAndSortingRepository<Slider, Long> {


    List<Slider> findAllByEnableIsTrue(Sort sort);
}
