package dev.omedia.config.datasource.another;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static dev.omedia.config.datasource.another.AnotherJpaProperties.UNIT_NAME;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "anotherEntityManagerFactory",
        basePackages = {"dev.omedia.domain.book"},
        transactionManagerRef = "anotherTransactionManager"
)
public class AnotherPersistenceConfig {
    private final static String PACKAGES_TO_SCAN = "dev.omedia.domain.book";

    private final AnotherDataSource dataSource;

    private final AnotherJpaProperties properties;

    @Autowired
    public AnotherPersistenceConfig(AnotherDataSource dataSource, AnotherJpaProperties properties) {
        this.dataSource = dataSource;
        this.properties = properties;
    }

    @Bean(name = "anotherDatasource")
    public DataSource dataSource() {
        return dataSource;
    }

    @Bean(name = "anotherEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("anotherDatasource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .properties(properties.getProperties())
                .packages(PACKAGES_TO_SCAN)
                .persistenceUnit(UNIT_NAME)
                .build();
    }

    @Bean("anotherTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("anotherEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
