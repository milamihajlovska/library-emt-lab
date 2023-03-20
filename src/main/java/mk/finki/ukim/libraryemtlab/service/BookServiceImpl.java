package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Book;
import mk.finki.ukim.libraryemtlab.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return Optional.empty();
    }

    @Override
    public Book addBook(BookDto bookDto) {
        return null;
    }

    @Override
    public Book editBook(Long id, BookDto bookDto) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public void markBookAsTaken(Long id) {

    }
}
