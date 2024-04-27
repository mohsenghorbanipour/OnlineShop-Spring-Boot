package devpro.onlineshop.app.controllers;

import devpro.onlineshop.app.entities.site.Slider;
import devpro.onlineshop.app.services.site.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SliderController {

    @Autowired
    private SliderService service;

    @GetMapping("/test")
    public List<Slider> findAllByOrderItem() {
        return service.findAllByOrderItem();
    }

}
