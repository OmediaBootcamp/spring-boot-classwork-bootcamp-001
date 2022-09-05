package dev.omedia.servicetwo.service;


import dev.omedia.serviceone.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class PersonReceiverService {

    private final RestTemplate restTemplate;
    private final UriComponentsBuilder uriBuilder;

    @Autowired
    public PersonReceiverService(RestTemplate restTemplate, UriComponentsBuilder uriBuilder) {
        this.restTemplate = restTemplate;
        this.uriBuilder = uriBuilder;
    }

    public Iterable<Person> getAll() throws URISyntaxException {
        URI uri = new URI(uriBuilder.cloneBuilder().path("persons").toUriString());
        ResponseEntity<Iterable> responseEntity =
                restTemplate.getForEntity(uri, Iterable.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
           Iterable<Person> res = responseEntity.getBody();
           return res;
        }
        throw new RuntimeException();
    }
}
