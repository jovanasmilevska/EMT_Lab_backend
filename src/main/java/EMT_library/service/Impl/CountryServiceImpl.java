package EMT_library.service.Impl;

import EMT_library.model.Country;
import EMT_library.repository.CountryRepository;
import EMT_library.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void save(String name, String content) {
    countryRepository.save(new Country(name,content));
    }

    @Override
    public Country findByName(String name) {
      return countryRepository.findByName(name);
    }
}
