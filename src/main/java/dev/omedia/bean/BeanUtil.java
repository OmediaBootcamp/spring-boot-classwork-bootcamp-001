package dev.omedia.bean;


import dev.omedia.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil {

    @Bean("thousand")
    public Config thousand() {
        return new Config(1000);
    }

    @Bean("defaultValue")
    public Config defaultValue() {
        return new Config();
    }


}
