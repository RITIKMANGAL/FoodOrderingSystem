package model;

import constant.OrderStatus;
import java.util.Collections;
import java.util.Map;

public class Order {
    private final int orderId;
    private final User user;
    private final Map<String, Integer> items;
    private Restaurant restaurant;
    private OrderStatus status;

    public Order(int orderId, User user, Map<String, Integer> items) {
        if (items == null || items.isEmpty())
            throw new IllegalArgumentException("Order items empty");

        this.orderId = orderId;
        this.user = user;
        this.items = Collections.unmodifiableMap(items);
        this.status = OrderStatus.ACCEPTED;
    }

    public int getOrderId() { return orderId; }
    public Map<String, Integer> getItems() { return items; }
    public Restaurant getRestaurant() { return restaurant; }
    public void assignRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
    public OrderStatus getStatus() { return status; }

    public void complete() {
        this.status = OrderStatus.COMPLETED;
    }
}
