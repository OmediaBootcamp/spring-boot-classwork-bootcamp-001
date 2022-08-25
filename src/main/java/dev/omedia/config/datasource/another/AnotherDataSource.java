package dev.omedia.config.datasource.another;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ConfigurationProperties(prefix = "bootcamp.book.datasource")
public class AnotherDataSource extends DriverManagerDataSource {
}
