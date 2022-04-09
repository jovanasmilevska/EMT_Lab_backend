package EMT_library.model.dto;

import EMT_library.model.Author;
import EMT_library.model.Category;
import lombok.Data;

@Data
public class BookDto {
    private Author author;
    private String name;
    private Category category;
    private Long id;

    public BookDto(Author author, String name, Category category, Long id) {
        this.author = author;
        this.name = name;
        this.category = category;
        this.id = id;
    }

}
