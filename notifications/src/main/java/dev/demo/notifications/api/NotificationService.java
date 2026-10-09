package dev.demo.notifications.api;

import dev.demo.orders.api.Order;

public interface NotificationService {
    void orderPlaced(Order order);
}
