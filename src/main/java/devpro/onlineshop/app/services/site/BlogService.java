package devpro.onlineshop.app.services.site;

import devpro.onlineshop.app.entities.site.Blog;
import devpro.onlineshop.app.helper.exceptions.DataNotFoundException;
import devpro.onlineshop.app.repositories.site.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repository;

    public List<Blog> search(String search) {
        return repository.findAllByTitleContainsOrDescriptionContains(search);
    }

    public Blog getById(long Id) {
        Optional<Blog> data = repository.findById(Id);
        if(data.isPresent()) return data.get();
        return null;
    }

    public Blog add(Blog data) {
        return repository.save(data);
    }

    public Blog update(Blog data) throws DataNotFoundException {
        Blog oldDate = getById(data.getId());
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + data.getId() + "not found"
            );
        }

        oldDate.setImage(data.getImage());
        oldDate.setTitle(data.getTitle());
        oldDate.setDescription(data.getDescription());
        oldDate.setStatus(data.getStatus());
        return repository.save(oldDate);
    }

    public boolean deleteById(long id) throws DataNotFoundException {
        Blog oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        repository.deleteById(id);
        return true;
    }

    public Blog increaseVisitCountById(long id) throws DataNotFoundException {
        Blog oldDate = getById(id);
        if(oldDate == null) {
            throw new DataNotFoundException(
                    "data with id" + id + "not found"
            );
        }
        oldDate.setVisitCount(oldDate.getVisitCount() + 1);
        return repository.save(oldDate);
    }
 }
