package devpro.onlineshop.app.controllers.api.site;

import devpro.onlineshop.app.entities.site.Slider;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.site.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/slider")
public class SliderController {

    @Autowired
    private SliderService service;

    @GetMapping("")
    public ServiceResponse<Slider> get() {
        try {
            List<Slider> result = service.findAllByOrderItem();
            return new ServiceResponse<Slider>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Slider>(
                    e
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Slider> getById(@PathVariable long id) {
        try {
            Slider result = service.getById(id);
            return new ServiceResponse<Slider>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Slider>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Slider> add(@RequestBody Slider data) {
        try {
            Slider result = service.add(data);
            return new ServiceResponse<Slider>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Slider>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Slider> update(@RequestBody Slider data) {
        try {
            Slider result = service.update(data);
            return new ServiceResponse<Slider>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Slider>(
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
