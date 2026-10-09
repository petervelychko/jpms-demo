package dev.demo.orders.internal;

import dev.demo.catalog.api.Catalog;
import dev.demo.catalog.api.CustomerTier;
import dev.demo.orders.api.Order;
import dev.demo.orders.api.OrderLine;
import dev.demo.orders.api.OrderService;
import dev.demo.orders.internal.persistence.OrderStore;
import dev.demo.promotions.PromotionEngine;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public final class DefaultOrderService implements OrderService {
    private final Catalog catalog;
    private final PromotionEngine promotions = new PromotionEngine();
    private final OrderStore store;

    public DefaultOrderService(Catalog catalog, OrderStore store) {
        this.catalog = catalog;
        this.store = store;
    }

    @Override
    public Order place(String sku, int quantity, CustomerTier tier) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        // Fixed architecture: Orders depends only on Catalog's exported API.
        BigDecimal catalogPrice = catalog.priceFor(sku, tier);
        BigDecimal unitPrice = promotions.apply(catalogPrice);
        BigDecimal total = unitPrice.multiply(BigDecimal.valueOf(quantity));

        var order = new Order(
                UUID.randomUUID(),
                List.of(new OrderLine(sku, quantity, unitPrice)),
                total
        );

        store.save(order);
        return order;
    }
}
