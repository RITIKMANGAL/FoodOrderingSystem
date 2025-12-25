package serviceImpl;

import model.Order;
import model.Restaurant;
import repository.OrderRepository;
import repository.RestaurantRepository;
import service.OrderService;
import service.SelectionStrategy;

public class OrderServiceImpl implements OrderService {

    private final RestaurantRepository rr;
    private final OrderRepository or;
    private SelectionStrategy defaultStrategy = new LowestCostStrategy();

    public OrderServiceImpl(RestaurantRepository rr, OrderRepository or) {
        this.rr = rr;
        this.or = or;
    }

    public void placeOrder(Order order) {
        placeOrder(order, defaultStrategy);
    }

    public void placeOrder(Order order, SelectionStrategy strategy) {
        Restaurant r = strategy.select(rr.findAll(), order.getItems());

        if (r == null) {
            System.out.println("Cannot assign the order");
            return;
        }

        r.incrementOrders();
        order.assignRestaurant(r);
        or.save(order);
        System.out.println("Order assigned to " + r.getName());
    }

    public void completeOrder(int orderId) {
        Order order = or.findById(orderId);
        order.getRestaurant().decrementOrders();
        order.complete();
    }
}
