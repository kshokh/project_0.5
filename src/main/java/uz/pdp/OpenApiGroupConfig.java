package uz.pdp;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiGroupConfig {

    @Bean
    public GroupedOpenApi adminApis() {
        return GroupedOpenApi.builder()
                .group( "Admin APIs" )
                .pathsToMatch( "/api/admin/**" )
                .build();
    }

    @Bean
    public GroupedOpenApi userApis() {
        return GroupedOpenApi.builder()
                .group( "User APIs" )
                .pathsToMatch( "/api/user/**" )
                .build();
    }
}
