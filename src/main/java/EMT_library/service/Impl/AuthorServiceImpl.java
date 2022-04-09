package EMT_library.service.Impl;

import EMT_library.model.Author;
import EMT_library.model.Country;
import EMT_library.repository.AuthorRepository;
import EMT_library.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(String name, String surname, Country country) {
        authorRepository.save(new Author(name,surname,country));
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }
}
