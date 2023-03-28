package mk.finki.ukim.libraryemtlab.repository;

import mk.finki.ukim.libraryemtlab.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
