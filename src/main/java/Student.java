
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(
        name = "Student.findByGender",
        query = "SELECT s FROM Student s WHERE s.gender = :gender"
)
@EntityListeners(AuditLogger.class)
public class Student {
}
