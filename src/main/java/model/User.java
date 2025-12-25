package model;

public class User {
    private final String name;

    public User(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Invalid user");
        this.name = name;
    }

    public String getName() { return name; }
}
