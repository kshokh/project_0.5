package uz.pdp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterController {

    private final MailService mailService;

    @PostMapping
    public ResponseEntity<String> register( @RequestBody RegisterRequest request ) {
        mailService.sendActivationEmail( request );
        return ResponseEntity.ok( "Activation email sent" );
    }
}
