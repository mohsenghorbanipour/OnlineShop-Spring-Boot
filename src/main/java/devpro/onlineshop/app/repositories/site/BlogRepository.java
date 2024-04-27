package devpro.onlineshop.app.repositories.site;

import devpro.onlineshop.app.entities.site.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
}
