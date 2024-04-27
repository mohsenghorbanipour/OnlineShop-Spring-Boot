package devpro.onlineshop.app.repositories.orders;

import devpro.onlineshop.app.entities.orders.Invoice;
import devpro.onlineshop.app.entities.site.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
}
