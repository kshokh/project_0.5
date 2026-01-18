package uz.pdp;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<Store> create( @Valid @RequestBody Store entity ) {
        return new ResponseEntity<>( entity, HttpStatus.CREATED );
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update")
    public ResponseEntity<Store> update( @Valid @RequestBody Store entity ) {
        return new ResponseEntity<>( entity, HttpStatus.OK );
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete( @PathVariable Long id ) {
        return new ResponseEntity<>( "Successfully Deleted - uz.pdp.Store", HttpStatus.NO_CONTENT );
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/get/{id}")
    public ResponseEntity<Store> get( @PathVariable Long id ) {
        return new ResponseEntity<>(
                new Store( id, "uz.pdp.Store", ".....@gmail.com", 20,
                        "The point of using Lorem Ipsum is that it" ),
                HttpStatus.OK
        );
    }
}
