package dev.demo.notifications.internal;

import dev.demo.notifications.api.NotificationService;
import dev.demo.orders.api.Order;

public final class ConsoleNotificationService implements NotificationService {
    @Override
    public void orderPlaced(Order order) {
        System.out.printf("Notification: order %s placed, total = %s%n", order.id(), order.total());
    }
}
