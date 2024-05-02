package devpro.onlineshop.app.controllers.api.site;

import devpro.onlineshop.app.entities.site.Blog;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.site.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService service;

    @GetMapping("")
    public ServiceResponse<Blog> search(@RequestParam String keyword) {
        try {
            List<Blog> result = service.search(keyword);
            return new ServiceResponse<Blog>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Blog>(
                  e
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Blog> getById(@PathVariable long id) {
        try {
            Blog result = service.getById(id);
            return new ServiceResponse<Blog>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Blog>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Blog> add(@RequestBody Blog data) {
        try {
            Blog result = service.add(data);
            return new ServiceResponse<Blog>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Blog>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Blog> update(@RequestBody Blog data) {
        try {
            Blog result = service.update(data);
            return new ServiceResponse<Blog>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Blog>(
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

    @PutMapping("/increaseVisit/{id}")
    public ServiceResponse<Blog> update(@PathVariable long id) {
        try {
            Blog result = service.increaseVisitCountById(id);
            return new ServiceResponse<Blog>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Blog>(
                    e
            );
        }
    }
}
