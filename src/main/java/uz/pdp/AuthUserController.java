package uz.pdp;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/users")
public class AuthUserController {

    private final AuthUserRepository repository;
    private final AuthUserModelAssembler assembler;

    public AuthUserController( AuthUserRepository repository,
                               AuthUserModelAssembler assembler ) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @PostMapping
    public ResponseEntity<AuthUserModel> createUser(
            @RequestBody AuthUserEntity user ) {

        AuthUserEntity saved = repository.save( user );

        return ResponseEntity
                .created( linkTo( methodOn( AuthUserController.class )
                        .getUser( saved.getId() ) ).toUri() )
                .body( assembler.toModel( saved ) );
    }

    @GetMapping("/{id}")
    public AuthUserModel getUser( @PathVariable Long id ) {
        return repository.findById( id )
                .map( assembler::toModel )
                .orElseThrow( () -> new EntityNotFoundException( "User not found" ) );
    }

    @GetMapping
    public CollectionModel<AuthUserModel> getAllUsers() {

        List<AuthUserModel> users = repository.findAll()
                .stream()
                .map( assembler::toModel )
                .toList();

        return CollectionModel.of( users,
                linkTo( methodOn( AuthUserController.class )
                        .getAllUsers() ).withSelfRel() );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthUserModel> updateUser(
            @PathVariable Long id,
            @RequestBody AuthUserEntity updatedUser ) {

        AuthUserEntity saved = repository.findById( id )
                .map( user -> {
                    user.setUsername( updatedUser.getUsername() );
                    user.setPassword( updatedUser.getPassword() );
                    return repository.save( user );
                } )
                .orElseThrow( () -> new EntityNotFoundException( "User not found" ) );

        return ResponseEntity.ok( assembler.toModel( saved ) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser( @PathVariable Long id ) {
        repository.deleteById( id );
        return ResponseEntity.noContent().build();
    }
}
