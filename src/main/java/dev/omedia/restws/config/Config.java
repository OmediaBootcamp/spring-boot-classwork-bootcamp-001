package dev.omedia.restws.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "beqa")
@Configuration
@Data
public class Config {
//    @Value("${my.host}")
    private  String host;

    @Override
    public String toString() {
        return host;
    }
}
