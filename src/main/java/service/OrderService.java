package service;

import model.Order;

public interface OrderService {
    void placeOrder(Order order);
    void placeOrder(Order order, SelectionStrategy strategy);
    void completeOrder(int orderId);
}
