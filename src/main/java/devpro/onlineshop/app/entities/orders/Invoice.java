package devpro.onlineshop.app.entities.orders;

import devpro.onlineshop.app.entities.people.Customer;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Date invoiceDate;
    private Date payedDate;
    @OneToMany
    @JoinColumn(name = "order_items")
    private List<OrderItem> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getPayedDate() {
        return payedDate;
    }

    public void setPayedDate(Date payedDate) {
        this.payedDate = payedDate;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }
}
