
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GROUP")
@EntityListeners(AuditLogger.class)
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "GROUP_NAME")
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;
}
