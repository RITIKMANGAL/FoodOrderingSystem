package service;

import model.Restaurant;
import java.util.Map;

public interface RestaurantService {
    void onboard(Restaurant restaurant);
    void addMenu(String restaurantName, Map<String, Double> items);
    void updateMenu(String restaurantName, Map<String, Double> items);
}
