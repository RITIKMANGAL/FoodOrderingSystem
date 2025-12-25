package repository;

import model.Order;
import java.util.*;

public class OrderRepository {
    private final Map<Integer, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Order findById(int id) {
        return orders.get(id);
    }
}
