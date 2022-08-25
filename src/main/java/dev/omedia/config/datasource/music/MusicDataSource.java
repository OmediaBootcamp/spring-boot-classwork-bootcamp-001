package dev.omedia.config.datasource.music;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ConfigurationProperties(prefix = "bootcamp.music.datasource")
public class MusicDataSource extends DriverManagerDataSource {
}
