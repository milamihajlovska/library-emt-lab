package mk.finki.ukim.libraryemtlab.repository;

import mk.finki.ukim.libraryemtlab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
