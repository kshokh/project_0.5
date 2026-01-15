package uz.pdp;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class AuthUserModel extends RepresentationModel<AuthUserModel> {

    private final Long id;
    private final String username;

    public AuthUserModel( Long id, String username ) {
        this.id = id;
        this.username = username;
    }
}
