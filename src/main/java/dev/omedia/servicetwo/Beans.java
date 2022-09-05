package dev.omedia.servicetwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class Beans {

    @Value("${person.service.host:localhost}")
    private String host ;

    @Value("${person.service.port:8080}")
    private Integer port;

    @Value("${person.service.scheme:http}")
    private String scheme;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("personServiceURIBuilder") // is not best practise
    public UriComponentsBuilder uriBuilder() {
        return UriComponentsBuilder.newInstance()
                .host(host).port(port).scheme(scheme);
    }
}
