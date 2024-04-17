package devpro.onlineshop.app.entities.orders;

import devpro.onlineshop.app.entities.people.Customer;
import devpro.onlineshop.app.entities.product.Product;
import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "product_ic")
    private Product product;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private long count;
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
