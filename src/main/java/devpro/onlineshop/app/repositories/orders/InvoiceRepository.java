package devpro.onlineshop.app.repositories.orders;

import devpro.onlineshop.app.entities.orders.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("from Invoice where customer.id = :customerId")
    List<Invoice> findAllByCustomer(long customerId);
}
