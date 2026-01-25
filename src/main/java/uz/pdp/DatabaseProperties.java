package uz.pdp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseProperties {
    @Value("${database.url}")
    private String url;


    @Value("${database.username}")
    private String username;


    @Value("${database.password}")
    private String password;
}
