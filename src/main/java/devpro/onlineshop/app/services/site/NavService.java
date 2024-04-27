package devpro.onlineshop.app.services.site;

import devpro.onlineshop.app.repositories.site.NavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavService {

    @Autowired
    private NavRepository repository;

}
