package devpro.onlineshop.app.controllers.api.product;

import devpro.onlineshop.app.entities.product.Product;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/find")
    public ServiceResponse<Product> getByCategory(@RequestParam long categoryId) {
        try {
            List<Product> result = service.findAllByCategory(categoryId);
            return new ServiceResponse<Product>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Product>(
                    e
            );
        }
    }

    @GetMapping("")
    public ServiceResponse<Product> search(@RequestParam String keyword) {
        try {
            List<Product> result = service.search(keyword);
            return new ServiceResponse<Product>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Product>(
                    e
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Product> getById(@PathVariable long id) {
        try {
            Product result = service.getById(id);
            return new ServiceResponse<Product>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Product>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Product> add(@RequestBody Product data) {
        try {
            Product result = service.add(data);
            return new ServiceResponse<Product>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Product>(
                    e
            );
        }
    }

    @PutMapping("")
    public ServiceResponse<Product> update(@RequestBody Product data) {
        try {
            Product result = service.update(data);
            return new ServiceResponse<Product>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Product>(
                    e
            );
        }
    }

    @DeleteMapping("/{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean result = service.deleteById(id);
            return new ServiceResponse<Boolean>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Boolean>(
                    e
            );
        }
    }


}
