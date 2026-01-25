package uz.pdp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService service;


    public UserController( UserService service ) {
        this.service = service;
    }


    @PostMapping
    public CompletableFuture<String> create( @RequestParam String name ) {
        return service.create( name );
    }
}