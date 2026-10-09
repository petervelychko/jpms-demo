package dev.demo.app;

import dev.demo.catalog.api.Catalogs;
import dev.demo.catalog.api.CustomerTier;
import dev.demo.notifications.api.Notifications;
import dev.demo.orders.api.Orders;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        System.out.printf("Java %s | module: %s%n",
                Runtime.version().feature(),
                Main.class.getModule().getName());

        var catalog = Catalogs.sample();
        var orders = Orders.create(catalog);
        var notifications = Notifications.console();

        var order = orders.place("java-mug", 2, CustomerTier.PREMIUM);
        notifications.orderPlaced(order);
    }
}
