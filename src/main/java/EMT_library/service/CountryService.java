package EMT_library.service;

import EMT_library.model.Country;

public interface CountryService {
    void save(String name, String content);
    Country findByName(String name);
}
