package dev.omedia.model;

import dev.omedia.dto.User;

public class Customer {
    private User user;

    public Customer(User user) {
        this.user = user;
    }

    public Customer(long id, String name) {
        this.user = new User(id, name);
    }

    public long getIdentification() {
        return user.getId();
    }

    public void setIdentification(long identification) {
        this.user.setId(identification);
    }

    public String getName() {
        return user.getName();
    }
}
