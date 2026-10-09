package dev.demo.orders.internal.persistence;

import dev.demo.orders.api.Order;

public interface OrderStore {
    void save(Order order);
}
