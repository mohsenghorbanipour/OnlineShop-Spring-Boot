package devpro.onlineshop.app.services.site;

import devpro.onlineshop.app.entities.site.Nav;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.site.NavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NavService {

    @Autowired
    private NavRepository repository;

    public List<Nav> findAllByOrderItem() {
        return  repository.findAllByEnableIsTrue(Sort.by("itemOrder"));
    }

    public Nav getById(long Id) {
        Optional<Nav> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Nav add(Nav data) {
        return repository.save(data);
    }

    public Nav update(Nav data) throws DataNotFoundException {
        Nav oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setTitle(data.getTitle());
        oldDate.setItemOrder(data.getItemOrder());
        oldDate.setEnable(data.isEnable());
        oldDate.setLink(data.getLink());
        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Nav oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }
}
