package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Book;
import mk.finki.ukim.libraryemtlab.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks();

    Optional<Book> findBookById(Long id);

    Optional<Book> addBook(BookDto bookDto);
    Optional<Book> editBook(Long id, BookDto bookDto);

    void deleteBook(Long id);
    void markBookAsTaken(Long id);
}
