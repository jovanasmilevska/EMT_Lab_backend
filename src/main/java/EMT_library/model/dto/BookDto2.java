package EMT_library.model.dto;

import EMT_library.model.Author;
import EMT_library.model.Category;
import lombok.Data;

@Data
public class BookDto2 {
    private String author;
    private String name;
    private Category category;
    private int availableCopies;


    public BookDto2(String author, String name, Category category, int availableCopies) {
        this.author = author;
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
