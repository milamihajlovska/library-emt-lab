package mk.finki.ukim.libraryemtlab.model.dto;

import lombok.Data;
import mk.finki.ukim.libraryemtlab.model.Category;

@Data
public class BookDto {
    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;
}
