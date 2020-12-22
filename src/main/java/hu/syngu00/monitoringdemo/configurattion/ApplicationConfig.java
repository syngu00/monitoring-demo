package hu.syngu00.monitoringdemo.configurattion;

import hu.syngu00.monitoringdemo.configurattion.proeprties.SwaggerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    @ConfigurationProperties(prefix = "hu.syngu.swagger")
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }
}
