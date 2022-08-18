package dev.omedia.model;

import dev.omedia.dto.User;

public class Customer {
    private User user;

    public Customer(User user) {
        this.user = user;
    }

    public long getIdentification() {
        return user.getId();
    }

    public void setIdentification(long identification) {
        this.user.setId(identification);
    }
}
