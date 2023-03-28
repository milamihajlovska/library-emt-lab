package mk.finki.ukim.libraryemtlab.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String name;
    private String surname;
    @ManyToOne
    private Country country;

}
