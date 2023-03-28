package mk.finki.ukim.libraryemtlab.repository;

import mk.finki.ukim.libraryemtlab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
