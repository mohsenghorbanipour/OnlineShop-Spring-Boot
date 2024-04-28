package devpro.onlineshop.app.services.site;

import devpro.onlineshop.app.entities.site.Content;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.site.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    public Content searchByKey(String key) {
        return  repository.findFirstByByKey(key);
    }

    public Content getById(long Id) {
        Optional<Content> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Content add(Content data) {
        return repository.save(data);
    }

    public Content update(Content data) throws DataNotFoundException {
        Content oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }
        oldDate.setValue(data.getValue());
        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Content oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }
}
