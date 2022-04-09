package EMT_library.DataInitializer;

import EMT_library.model.Author;
import EMT_library.model.Book;
import EMT_library.model.Category;
import EMT_library.model.Country;
import EMT_library.service.AuthorService;
import EMT_library.service.BookService;
import EMT_library.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void initData(){

        for(int i =0; i<5; i++){
            countryService.save("Country "+i,"**CONTENT**");
        }
        for(int i =0; i<5; i++){
            Country c=countryService.findByName("Country "+i);
            authorService.save("Name "+i, "Surname "+ i,c);
        }

        for(int i =0; i<5; i++){
            Author a=authorService.findByName("Name "+i);
            bookService.save("Book "+i,Category.CLASSICS,a,i+10);
            bookService.save("Book "+i,Category.BIOGRAPHY,a,i+10);
            bookService.save("Book "+i,Category.DRAMA,a,i+10);
            bookService.save("Book "+i,Category.FANTASY,a,i+10);
            bookService.save("Book "+i,Category.HISTORY,a,i+10);
            bookService.save("Book "+i,Category.NOVEL,a,i+10);
            bookService.save("Book "+i,Category.THRILER,a,i+10);

        }
    }

}
