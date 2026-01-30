package uz.pdp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    private String title;

    private boolean completed;
}
