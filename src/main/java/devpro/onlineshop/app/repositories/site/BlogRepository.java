package devpro.onlineshop.app.repositories.site;

import devpro.onlineshop.app.entities.site.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("from Blog where title like concat('%',:search,'%') or description like concat('%',:search,'%' )")
    List<Blog> findAllByTitleContainsOrDescriptionContains(String search);
}
