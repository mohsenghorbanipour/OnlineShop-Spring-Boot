package devpro.onlineshop.app.repositories.orders;

import devpro.onlineshop.app.entities.orders.Invoice;
import devpro.onlineshop.app.entities.site.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {

    @Query("from Invoice where customer.id = :customerId")
    List<Invoice> findAllByCustomer(long customerId);
}
