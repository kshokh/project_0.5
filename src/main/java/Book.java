
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    private String title;
    private String description;
    private Double price;
    private String author;

    public Book() {
    }

    public Book( String title, String description, Double price, String author ) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
    }
}
