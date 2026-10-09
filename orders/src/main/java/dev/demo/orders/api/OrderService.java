package dev.demo.orders.api;

import dev.demo.catalog.api.CustomerTier;

public interface OrderService {
    Order place(String sku, int quantity, CustomerTier tier);
}
