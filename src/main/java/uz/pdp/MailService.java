package uz.pdp;

import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;

@Service
@Profile("prod")
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private final Configuration freemarkerConfig;

    public void sendActivationEmail( RegisterRequest request ) {
        try {
            Template template = freemarkerConfig.getTemplate( "activation.ftl" );

            Map<String, Object> model = new HashMap<>();
            model.put( "username", request.getUsername() );
            model.put( "activationLink", "https://example.com/activate" );

            String html = FreeMarkerTemplateUtils.processTemplateIntoString( template, model );

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper( message, true );
            helper.setTo( request.getEmail() );
            helper.setSubject( "Activate your account" );
            helper.setText( html, true );

            mailSender.send( message );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }
}
