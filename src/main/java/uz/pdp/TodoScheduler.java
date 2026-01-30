package uz.pdp;

import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import freemarker.template.Configuration;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TodoScheduler {

    private final TodoRepository todoRepository;
    private final JavaMailSender mailSender;
    private final Configuration freemarkerConfig;

    @Scheduled(cron = "0 0 8,20 * * *")
    public void sendUncompletedTodos() throws Exception {
        List<Todo> todos = todoRepository.findByCompletedFalse();

        Template template = freemarkerConfig.getTemplate( "todos.ftl" );
        Map<String, Object> model = Map.of( "todos", todos );

        String html = FreeMarkerTemplateUtils.processTemplateIntoString( template, model );

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper( message, true );
        helper.setTo( "yourgmail@gmail.com" );
        helper.setSubject( "Uncompleted TODOs" );
        helper.setText( html, true );

        mailSender.send( message );
    }
}
