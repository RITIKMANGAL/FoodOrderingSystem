package serviceImpl;

import model.Restaurant;
import service.SelectionStrategy;
// ...existing code...
public class HighestRatingStrategy implements SelectionStrategy {
    public Restaurant select(java.util.List<Restaurant> restaurants, java.util.Map<String, Integer> items) {
        Restaurant best = null;
        double maxRating = -1;
        for (Restaurant r : restaurants) {
            if (!r.canAcceptOrder()) continue;
            boolean ok = true;
            for (String item : items.keySet()) {
                if (!r.getMenu().containsKey(item)) {
                    ok = false;
                    break;
                }
            }
            if (ok && r.getRating() > maxRating) {
                maxRating = r.getRating();
                best = r;
            }
        }
        return best;
    }
}
