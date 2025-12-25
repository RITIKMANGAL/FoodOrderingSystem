package model;

import pojo.MenuItem;
import java.util.*;

public class Restaurant {
    private final String name;
    private final int maxOrders;
    private final double rating;
    private int currentOrders;
    private final Map<String, MenuItem> menu = new HashMap<>();

    public Restaurant(String name, int maxOrders, double rating) {
        if (name == null || name.isEmpty() || maxOrders <= 0 || rating < 0 || rating > 5)
            throw new IllegalArgumentException("Invalid restaurant data");

        this.name = name;
        this.maxOrders = maxOrders;
        this.rating = rating;
    }

    public String getName() { return name; }
    public double getRating() { return rating; }
    public Map<String, MenuItem> getMenu() { return menu; }

    public boolean canAcceptOrder() {
        return currentOrders < maxOrders;
    }

    public void incrementOrders() { currentOrders++; }
    public void decrementOrders() { currentOrders--; }
}
