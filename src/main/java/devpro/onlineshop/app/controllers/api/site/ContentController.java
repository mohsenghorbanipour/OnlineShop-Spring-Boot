package devpro.onlineshop.app.controllers.api.site;

import devpro.onlineshop.app.entities.site.Content;
import devpro.onlineshop.app.entities.site.Content;
import devpro.onlineshop.app.helper.ui.ResponseStatus;
import devpro.onlineshop.app.helper.ui.ServiceResponse;
import devpro.onlineshop.app.services.site.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService service;

    @GetMapping("")
    public ServiceResponse<Content> search(@RequestParam String keyword) {
        try {
            Content result = service.searchByKey(keyword);
            return new ServiceResponse<Content>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Content>(
                    e
            );
        }
    }

    @GetMapping("/{id}")
    public ServiceResponse<Content> getById(@PathVariable long id) {
        try {
            Content result = service.getById(id);
            return new ServiceResponse<Content>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Content>(
                    e
            );
        }
    }

    @PostMapping("/add")
    public ServiceResponse<Content> add(@RequestBody Content data) {
        try {
            Content result = service.add(data);
            return new ServiceResponse<Content>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Content>(
                    e
            );
        }
    }

    @PutMapping("/")
    public ServiceResponse<Content> update(@RequestBody Content data) {
        try {
            Content result = service.update(data);
            return new ServiceResponse<Content>(
                    ResponseStatus.SUCCESS,
                    result
            );
        } catch (Exception e) {
            return  new ServiceResponse<Content>(
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
