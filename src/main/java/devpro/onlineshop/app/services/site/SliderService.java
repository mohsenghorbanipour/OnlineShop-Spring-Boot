package devpro.onlineshop.app.services.site;

import devpro.onlineshop.app.entities.site.Slider;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.site.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SliderService {

    @Autowired
    private SliderRepository repository;

    public List<Slider> findAllByOrderItem() {
        return repository.findAllByEnableIsTrue(Sort.by("itemOrder"));
    }

    public Slider getById(long Id) {
        Optional<Slider> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Slider add(Slider data) {
        return repository.save(data);
    }

    public Slider update(Slider data) throws DataNotFoundException {
        Slider oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }

        oldDate.setImage(data.getImage());
        oldDate.setTitle(data.getTitle());
        oldDate.setDescription(data.getDescription());
        oldDate.setItemOrder(data.getItemOrder());
        oldDate.setEnable(data.isEnable());
        oldDate.setLink(data.getLink());
        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Slider oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }
 }
