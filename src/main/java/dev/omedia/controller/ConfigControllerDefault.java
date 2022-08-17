package dev.omedia.controller;

import dev.omedia.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigControllerDefault {
    private final Config config;

    @Autowired
    public ConfigControllerDefault(
            @Qualifier("defaultValue") Config config
    ) {
        this.config = config;
    }

    @GetMapping(produces = "application/json")
    public Config returnConfigValue() {
        return config;
    }
}
