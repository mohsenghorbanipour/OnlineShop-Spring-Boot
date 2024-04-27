package devpro.onlineshop.app.repositories.orders;

import devpro.onlineshop.app.entities.orders.OrderItem;
import devpro.onlineshop.app.entities.site.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {
}
