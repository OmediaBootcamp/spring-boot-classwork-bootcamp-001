package dev.omedia.config.datasource.music;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "bootcamp.music.jpa")
@Data
public class MusicJpaProperties {
    public static final String UNIT_NAME = "music";

    private final Map<String, String> properties = new HashMap<>();

    public Map<String, String> getProperties() {
        return properties;
    }
}
