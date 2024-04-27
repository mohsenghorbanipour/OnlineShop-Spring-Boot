package devpro.onlineshop.app.services.site;

import devpro.onlineshop.app.entities.site.Slider;
import devpro.onlineshop.app.repositories.site.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SliderService {

    @Autowired
    private SliderRepository repository;

    public List<Slider> findAllByOrderItem() {
        return (List<Slider>) repository.findAllByEnableIsTrue(Sort.by("itemOrder"));
    }
 }
