package devpro.onlineshop.app.repositories.site;

import devpro.onlineshop.app.entities.site.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    Content findFirstByByKey(String key);

}
