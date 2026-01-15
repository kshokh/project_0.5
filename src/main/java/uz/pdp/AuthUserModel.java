package uz.pdp;

import org.springframework.hateoas.RepresentationModel;

public class AuthUserModel extends RepresentationModel<AuthUserModel> {

    private final Long id;
    private final String username;

    public AuthUserModel( Long id, String username ) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
