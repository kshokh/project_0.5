package uz.abc.Store.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String desc;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Item> items;
}
