package mk.finki.ukim.libraryemtlab.controller;

import mk.finki.ukim.libraryemtlab.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping()
    public List<Category> getAllCategories() {
        return Arrays.asList(Category.values());
    }

}
