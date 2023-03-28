package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Author;
import mk.finki.ukim.libraryemtlab.model.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<Author> findAllAuthors();

    Author findAuthorById(Long id);

    Author addAuthor(AuthorDto authorDto);
    Author editAuthor(Long id,AuthorDto authorDto);

    void deleteAuthor(Long id);
}
