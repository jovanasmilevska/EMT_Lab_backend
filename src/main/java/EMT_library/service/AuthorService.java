package EMT_library.service;

import EMT_library.model.Author;
import EMT_library.model.Country;

public interface AuthorService {
    void save(String name, String surname, Country country);
    Author findByName(String name);
}
