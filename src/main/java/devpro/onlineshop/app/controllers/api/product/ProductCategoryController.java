package devpro.onlineshop.app.controllers.api.product;

import devpro.onlineshop.app.entities.product.ProductCategory;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;


    @GetMapping("")
    public ServiceResponse<ProductCategory> get() {
        try {
            List<ProductCategory> result = service.findAllByEnableIsTrue();
            return new ServiceResponse<ProductCategory>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<ProductCategory>(
                    e
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<ProductCategory> getById(@PathVariable long id) {
        try {
            ProductCategory result = service.getById(id);
            return new ServiceResponse<ProductCategory>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<ProductCategory>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<ProductCategory> add(@RequestBody ProductCategory data) {
        try {
            ProductCategory result = service.add(data);
            return new ServiceResponse<ProductCategory>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<ProductCategory>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<ProductCategory> update(@RequestBody ProductCategory data) {
        try {
            ProductCategory result = service.update(data);
            return new ServiceResponse<ProductCategory>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<ProductCategory>(
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
