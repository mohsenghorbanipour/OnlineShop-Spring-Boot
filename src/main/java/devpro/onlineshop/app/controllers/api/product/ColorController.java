package devpro.onlineshop.app.controllers.api.product;

import devpro.onlineshop.app.entities.product.Color;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.product.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/color")
public class ColorController {

    @Autowired
    private ColorService service;


    @GetMapping("/{id}")
    public ServiceResponse<Color> getById(@PathVariable long id) {
        try {
            Color result = service.getById(id);
            return new ServiceResponse<Color>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Color>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Color> add(@RequestBody Color data) {
        try {
            Color result = service.add(data);
            return new ServiceResponse<Color>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Color>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Color> update(@RequestBody Color data) {
        try {
            Color result = service.update(data);
            return new ServiceResponse<Color>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Color>(
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
