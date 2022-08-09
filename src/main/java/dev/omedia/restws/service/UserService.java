package dev.omedia.restws.service;

import dev.omedia.restws.exceptions.UserNotFoundException;
import dev.omedia.restws.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService {
    private final Set<User> users = new HashSet<>(Arrays.asList(
            new User(25, "Gia", "Giorgadze", "Gia2002", LocalDate.now(), LocalDate.now()),
            new User(26, "Nino", "Svanidze", "Ninonino", LocalDate.now(), LocalDate.now()),
            new User(27, "Giorgi", "Beridze", "Gio27", LocalDate.now(), LocalDate.now())
    ));

    public Collection<User> getUsers() {
        return Collections.unmodifiableCollection(this.users);
    }

    public Optional<User> getUser(long id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findAny();
    }

    public boolean addUser(final User user) {
        long maxId = this.users.stream()
                .map(User::getId)
                .max(Long::compare)
                .orElse(0L);
        user.setId(maxId + 1);
        return this.users.add(user);
    }

    public boolean updateUser(final long id, final User user) {
        this.removeUser(id).orElseThrow(UserNotFoundException::new);
        user.setId(id);
        return this.addUser(user);
    }

    public Optional<User> removeUser(final long id) {
        Optional<User> currUser = this.users.stream()
                .filter(user -> user.getId() == id)
                .findAny();
        currUser.ifPresent(this.users::remove);
        return currUser;
    }
}
