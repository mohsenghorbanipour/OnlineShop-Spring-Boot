package devpro.onlineshop.app.controllers.api.product;

import devpro.onlineshop.app.entities.product.Feature;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.product.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/feature")
public class FeatureController {

    @Autowired
    private FeatureService service;


    @GetMapping("/{id}")
    public ServiceResponse<Feature> getById(@PathVariable long id) {
        try {
            Feature result = service.getById(id);
            return new ServiceResponse<Feature>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Feature>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Feature> add(@RequestBody Feature data) {
        try {
            Feature result = service.add(data);
            return new ServiceResponse<Feature>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Feature>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Feature> update(@RequestBody Feature data) {
        try {
            Feature result = service.update(data);
            return new ServiceResponse<Feature>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Feature>(
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
