package dev.omedia.config.datasource.another;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "bootcamp.another.jpa")
@Data
public class AnotherJpaProperties {
    public static final String UNIT_NAME = "another";
    private final Map<String, String> properties = new HashMap<>();
    public Map<String, String> getProperties() {
        return properties;
    }
}
