package dev.omedia.client;

import dev.omedia.entity.Post;
import feign.Feign;
import feign.Response;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "testClient",
        url = "http://localhost:8080/posts",
        fallback = TestClientFallBack.class,
        configuration = ClientConfiguration.class
)
public interface TestClient {
    @GetMapping
    List<Post> getPosts();

    @GetMapping("/{id}")
    Optional<Post> getPost(@PathVariable("id") Long id);
}

@Component
class TestClientFallBack implements TestClient {

    @Override
    public List<Post> getPosts() {
        return Collections.emptyList();
    }

    @Override
    public Optional<Post> getPost(Long id) {
        return Optional.of(new Post(10L, "Desc15"));
    }
}


@Slf4j
class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        log.info("methodKey: " + methodKey);
        log.info("response: " + response);
        switch (response.status()) {
            case 400:
                return new IllegalAccessException();
            case 404:
                return new IllegalArgumentException();
            default:
                return new Exception("Generic error");
        }
    }
}

@Configuration
class ClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public Retryer retryer() {
        int maxAttempt = 3;
        int period = 5000;
        return new Retryer.Default(period, maxAttempt * period, maxAttempt);
    }
}
