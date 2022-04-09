package EMT_library.service;


import EMT_library.model.Author;
import EMT_library.model.Book;
import EMT_library.model.Category;
import EMT_library.model.dto.BookDto;
import EMT_library.model.dto.BookDto2;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    void deleteById(Long id);

    void save(String name, Category category, Author author, Integer availableCopies);

    Optional<Book> findById(Long id);

    Page<Book> findPaginated(int page);

    void editBook(BookDto bookDto);

    void addBook(BookDto2 book);

    void markTaken(Long id);
}
