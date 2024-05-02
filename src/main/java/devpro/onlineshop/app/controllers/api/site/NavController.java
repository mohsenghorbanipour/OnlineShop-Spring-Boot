package devpro.onlineshop.app.controllers.api.site;

import devpro.onlineshop.app.entities.site.Nav;
import devpro.onlineshop.app.entities.site.Nav;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.site.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/nav")
public class NavController {

    @Autowired
    private NavService service;

    @GetMapping("")
    public ServiceResponse<Nav> get() {
        try {
            List<Nav> result = service.findAllByOrderItem();
            return new ServiceResponse<Nav>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Nav>(
                    e
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Nav> getById(@PathVariable long id) {
        try {
            Nav result = service.getById(id);
            return new ServiceResponse<Nav>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Nav>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Nav> add(@RequestBody Nav data) {
        try {
            Nav result = service.add(data);
            return new ServiceResponse<Nav>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Nav>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Nav> update(@RequestBody Nav data) {
        try {
            Nav result = service.update(data);
            return new ServiceResponse<Nav>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Nav>(
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
