package repository;

import model.User;
import java.util.*;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public User save(String name) {
        User user = new User(name);
        users.put(name, user);
        return user;
    }
}
