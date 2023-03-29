package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Book;
import mk.finki.ukim.libraryemtlab.model.dto.BookDto;
import mk.finki.ukim.libraryemtlab.repository.AuthorRepository;
import mk.finki.ukim.libraryemtlab.repository.BookRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> addBook(BookDto bookDto) {

//        Book book=new Book();
//        book.setAuthor(this.authorRepository.findById(bookDto.getAuthor()).get());
//        book.setName(bookDto.getName());
//        book.setCategory(bookDto.getCategory());
//        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(),bookDto.getCategory(),this.authorRepository.findById(bookDto.getAuthor()).get(),bookDto.getAvailableCopies())));

    }

    @Override
    public Optional<Book> editBook(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).get();
        book.setAuthor(this.authorRepository.findById(bookDto.getAuthor()).get());
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));

    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void markBookAsTaken(Long id) {
        Book book=this.bookRepository.findById(id).get();
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBooksByPage(Pageable pageable) {
        return bookRepository.findAll(pageable).getContent();
    }
}
