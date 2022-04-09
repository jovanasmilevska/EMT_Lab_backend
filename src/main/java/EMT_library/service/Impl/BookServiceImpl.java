package EMT_library.service.Impl;

import EMT_library.model.Author;
import EMT_library.model.Book;
import EMT_library.model.Category;
import EMT_library.model.dto.BookDto;
import EMT_library.model.dto.BookDto2;
import EMT_library.model.exception.BookNotFound;
import EMT_library.repository.AuthorRepository;
import EMT_library.repository.BookRepository;
import EMT_library.repository.CountryRepository;
import EMT_library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void save(String name, Category category, Author author, Integer availableCopies) {
        bookRepository.save(new Book(name, category, author, availableCopies));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Page<Book> findPaginated(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return bookRepository.findAll(pageable);
    }

    @Override
    public void editBook(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).orElseGet(null);
        if (book != null) {
            int copies = book.getAvailableCopies();
            bookRepository.deleteById(bookDto.getId());
            book.setName(bookDto.getName());
            book.setAuthor(bookDto.getAuthor());
            book.setCategory(bookDto.getCategory());
            book.setAvailableCopies(copies);
            bookRepository.save(book);
        }
    }

    @Override
    public void addBook(BookDto2 book) {

        Author a = new Author(book.getAuthor(),
                "Surname " + book.getAuthor(), countryRepository.findAll().get(0));
        authorRepository.save(a);

        bookRepository.save(new Book(book.getName(), book.getCategory(), a, book.getAvailableCopies()));

    }

    @Override
    public void markTaken(Long id) {
        Book book=bookRepository.findById(id).orElseGet(null);
        if(book!=null){
            int copies=book.getAvailableCopies();
            book.setAvailableCopies(copies-1);
            bookRepository.save(book);
        }
    }
}
