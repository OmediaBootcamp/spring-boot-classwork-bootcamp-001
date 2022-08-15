package dev.omedia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
    @Value("123")
    private int value;

    public int getValue() {
        return value;
    }
}
