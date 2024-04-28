package devpro.onlineshop.app.repositories.site;

import devpro.onlineshop.app.entities.site.Nav;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NavRepository extends JpaRepository<Nav, Long> {

    List<Nav> findAllByEnableIsTrue(Sort sort);
}
