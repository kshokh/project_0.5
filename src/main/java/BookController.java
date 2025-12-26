
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController( BookService service ) {
        this.service = service;
    }

    // READ: List all books
    @GetMapping
    public String listBooks( Model model ) {
        model.addAttribute( "books", service.findAll() );
        return "book-list";
    }

    // CREATE: Show form
    @GetMapping("/new")
    public String showCreateForm( Model model ) {
        model.addAttribute( "book", new Book() );
        return "book-form";
    }

    // CREATE & UPDATE
    @PostMapping
    public String saveBook( @ModelAttribute Book book ) {
        service.save( book );
        return "redirect:/books";
    }

    // UPDATE: Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm( @PathVariable Long id, Model model ) {
        model.addAttribute( "book", service.findById( id ) );
        return "book-form";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteBook( @PathVariable Long id ) {
        service.delete( id );
        return "redirect:/books";
    }

    // SEARCH
    @GetMapping("/search")
    public String searchBooks( @RequestParam("keyword") String keyword, Model model ) {
        model.addAttribute( "books", service.search( keyword ) );
        return "book-list";
    }
}
