package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Author;
import mk.finki.ukim.libraryemtlab.model.dto.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Author> findAllAuthors() {
        return null;
    }

    @Override
    public Author findAuthorById(Long id) {
        return null;
    }

    @Override
    public Author addAuthor(AuthorDto authorDto) {
        return null;
    }

    @Override
    public Author editAuthor(Long id, AuthorDto authorDto) {
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {

    }
}
