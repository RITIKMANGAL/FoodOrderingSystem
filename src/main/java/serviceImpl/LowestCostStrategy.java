package serviceImpl;

import model.Restaurant;
import service.SelectionStrategy;

// ...existing code...
public class LowestCostStrategy implements SelectionStrategy {
    public Restaurant select(java.util.List<Restaurant> restaurants, java.util.Map<String, Integer> items) {
        Restaurant best = null;
        double minCost = Double.MAX_VALUE;

        for (Restaurant r : restaurants) {
            if (!r.canAcceptOrder()) continue;
            double cost = 0;
            boolean ok = true;
            for (String item : items.keySet()) {
                pojo.MenuItem menuItem = r.getMenu().get(item);
                if (menuItem == null) {
                    ok = false;
                    break;
                }
                cost += menuItem.getPrice() * items.get(item);
            }
            if (ok && cost < minCost) {
                minCost = cost;
                best = r;
            }
        }
        return best;
    }
}