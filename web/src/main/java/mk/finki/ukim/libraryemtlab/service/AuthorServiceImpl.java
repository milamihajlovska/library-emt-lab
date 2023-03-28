package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Author;
import mk.finki.ukim.libraryemtlab.model.Country;
import mk.finki.ukim.libraryemtlab.model.dto.AuthorDto;
import mk.finki.ukim.libraryemtlab.repository.AuthorRepository;
import mk.finki.ukim.libraryemtlab.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Author addAuthor(AuthorDto authorDto) {
        Author author=new Author();
        Country country=countryRepository.findById(authorDto.getCountry()).orElseThrow(()->new RuntimeException());
        author.setName(authorDto.getName());
        author.setCountry(country);
        author.setSurname(authorDto.getSurname());

        return this.authorRepository.save(author);
    }

    @Override
    public Author editAuthor(Long id, AuthorDto authorDto) {
        Author author=authorRepository.findById(id).orElseThrow(()-> new RuntimeException());
        Country country=countryRepository.findById(authorDto.getCountry()).orElseThrow(()->new RuntimeException());
        author.setName(authorDto.getName());
        author.setCountry(country);
        author.setSurname(authorDto.getSurname());

        return this.authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
