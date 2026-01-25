package uz.pdp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
public class PersonConfig {
    private Long id;
    private String name;
    private Integer age;
}