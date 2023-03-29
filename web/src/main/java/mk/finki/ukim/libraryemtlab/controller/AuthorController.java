package mk.finki.ukim.libraryemtlab.controller;

import mk.finki.ukim.libraryemtlab.model.Author;
import mk.finki.ukim.libraryemtlab.model.Category;
import mk.finki.ukim.libraryemtlab.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping()
    public List<Author> getAllAuthors() {
        return authorService.findAllAuthors();
    }


}
