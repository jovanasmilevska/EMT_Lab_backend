package EMT_library.repository;

import EMT_library.model.Author;
import EMT_library.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findByName(String name);
    Author findByNameAndAndSurnameAndAndCountry(String name, String surname, Country c);
}
