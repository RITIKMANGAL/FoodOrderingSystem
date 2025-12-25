package serviceImpl;

import model.Restaurant;
import pojo.MenuItem;
import repository.RestaurantRepository;
import service.RestaurantService;

import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repo;

    public RestaurantServiceImpl(RestaurantRepository repo) {
        this.repo = repo;
    }

    public void onboard(Restaurant restaurant) {
        repo.save(restaurant);
    }

    public void addMenu(String name, Map<String, Double> items) {
        for (Restaurant r : repo.findAll()) {
            if (r.getName().equals(name)) {
                items.forEach((k, v) -> r.getMenu().put(k, new MenuItem(k, v)));
            }
        }
    }

    public void updateMenu(String name, Map<String, Double> items) {
        for (Restaurant r : repo.findAll()) {
            if (r.getName().equals(name)) {
                items.forEach((k, v) -> r.getMenu().get(k).updatePrice(v));
            }
        }
    }
}
