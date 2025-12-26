
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService( BookRepository repository ) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book save( Book book ) {
        return repository.save( book );
    }

    public Book findById( Long id ) {
        return repository.findById( id ).orElse( null );
    }

    public void delete( Long id ) {
        repository.deleteById( id );
    }

    public List<Book> search( String keyword ) {
        return repository
                .findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                        keyword, keyword, keyword
                );
    }
}
