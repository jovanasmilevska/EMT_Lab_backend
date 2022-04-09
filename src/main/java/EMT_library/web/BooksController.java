package EMT_library.web;

import EMT_library.model.Book;
import EMT_library.model.Category;
import EMT_library.model.dto.BookDto;
import EMT_library.model.dto.BookDto2;
import EMT_library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;


    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> listAllBooks() {
        System.out.println("aaa");
        return bookService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable Long id) {
     Book book = bookService.findById(id).orElseGet(null);
     if(book!=null){
         return new BookDto(book.getAuthor(),book.getName(),book.getCategory(),book.getId());
     }
     return null;
    }

    @GetMapping("/paginated/{pageNum}")
    public List<Book> findPaginatedBooks(@PathVariable int pageNum) {
        Page<Book> page = bookService.findPaginated(pageNum);
        System.out.println("paginated");
        return page.getContent();
    }

    @GetMapping("/totalLength")
    public int getBooksLength() {
        System.out.println("total");
        return bookService.findAll().size();
    }

    @GetMapping("/allCategories")
    public List<Category> getAllCategories() {
        List<Category> enumValues = Stream.of(Category.values()).collect(Collectors.toList());
        return enumValues;
    }

    @GetMapping("/edit/{id}")
    public BookDto getBookToEdit(@PathVariable Long id) {
        Book book = bookService.findById(id).orElseGet(null);
        if (book != null) {
            BookDto bookDto = new BookDto(book.getAuthor(), book.getName(), book.getCategory(), book.getId());
            return bookDto;
        }
        return null;
    }

    @PostMapping("/edit")
    public void editBook(@RequestBody BookDto bookDto){
        bookService.editBook(bookDto);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody BookDto2 book){
        bookService.addBook(book);
        System.out.println("dto2");
    }

    @GetMapping("/markTaken/{id}")
    public void markTakenBook(@PathVariable Long id){
        bookService.markTaken(id);
    }

}
