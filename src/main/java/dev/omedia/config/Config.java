package dev.omedia.config;

//@Component
public class Config {
    //    @Value("123")
    private int value;

    public Config() {
        value = 123;
    }

    public Config(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
