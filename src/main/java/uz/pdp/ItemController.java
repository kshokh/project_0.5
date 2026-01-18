package uz.pdp;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Item> create( @Valid @RequestBody Item item ) {
        return new ResponseEntity<>( item, HttpStatus.CREATED );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Item> update( @Valid @RequestBody Item item ) {
        return new ResponseEntity<>( item, HttpStatus.OK );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete( @PathVariable Long id ) {
        return new ResponseEntity<>( "Successfully Deleted - uz.pdp.Item", HttpStatus.NO_CONTENT );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/get/{id}")
    public ResponseEntity<Item> get( @PathVariable Long id ) {
        return new ResponseEntity<>(
                new Item( id, "Swagger", "Lorem Ipsum", 216.86D ),
                HttpStatus.OK
        );
    }
}
