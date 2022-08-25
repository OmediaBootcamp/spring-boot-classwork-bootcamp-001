package dev.omedia.config.datasource.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static dev.omedia.config.datasource.music.MusicJpaProperties.UNIT_NAME;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "musicEntityManagerFactory",
        basePackages = {"dev.omedia.repository"},
        transactionManagerRef = "musicTransactionManager"
)
public class MusicPersistenceConfig {
    private static final String PACKAGES_TO_SCAN = "dev.omedia.domain.music";

    private final MusicDataSource dataSource;
    private final MusicJpaProperties properties;

    @Autowired
    public MusicPersistenceConfig(MusicDataSource dataSource, MusicJpaProperties properties) {
        this.dataSource = dataSource;
        this.properties = properties;
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return dataSource;
    }

    @Primary
    @Bean(name = "musicEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(properties.getProperties())
                .packages(PACKAGES_TO_SCAN)
                .persistenceUnit(UNIT_NAME)
                .build();
    }

    @Primary
    @Bean("musicTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("musicEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
