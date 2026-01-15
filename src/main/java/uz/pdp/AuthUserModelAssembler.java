package uz.pdp;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AuthUserModelAssembler
        implements RepresentationModelAssembler<AuthUserEntity, AuthUserModel> {

    @Override
    public AuthUserModel toModel( AuthUserEntity entity ) {

        AuthUserModel model =
                new AuthUserModel( entity.getId(), entity.getUsername() );

        model.add( linkTo( methodOn( AuthUserController.class )
                .getUser( entity.getId() ) ).withSelfRel() );

        model.add( linkTo( methodOn( AuthUserController.class )
                .getAllUsers() ).withRel( "users" ) );

        model.add( linkTo( methodOn( AuthUserController.class )
                .deleteUser( entity.getId() ) ).withRel( "delete" ) );

        return model;
    }
}
