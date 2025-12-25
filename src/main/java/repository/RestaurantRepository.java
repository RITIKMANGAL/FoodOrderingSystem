package repository;

import model.Restaurant;
import java.util.*;

public class RestaurantRepository {
    private final List<Restaurant> restaurants = new ArrayList<>();

    public void save(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findByName(String name) {
        for (Restaurant r : restaurants) {
            if (r.getName().equalsIgnoreCase(name)) {
                return r;
            }
        }
        return null;
    }

    public void addOrUpdateMenuItem(String restaurantName, String itemName, int price) {
        Restaurant r = findByName(restaurantName);
        if (r == null) throw new RuntimeException("Restaurant not found");
        Map<String, pojo.MenuItem> menu = r.getMenu();
        if (menu.containsKey(itemName)) {
            menu.get(itemName).setPrice(price); // update price
        } else {
            menu.put(itemName, new pojo.MenuItem(itemName, price)); // add new
        }
    }
} 