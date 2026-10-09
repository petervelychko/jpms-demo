package dev.demo.orders.internal;

import dev.demo.catalog.api.Catalog;
import dev.demo.catalog.api.CustomerTier;
import dev.demo.catalog.internal.PricingRules;
import dev.demo.orders.api.Order;
import dev.demo.orders.api.OrderLine;
import dev.demo.orders.api.OrderService;
import dev.demo.orders.internal.persistence.OrderStore;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public final class DefaultOrderService implements OrderService {
    private final Catalog catalog;
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

        var product = catalog.find(sku)
                .orElseThrow(() -> new IllegalArgumentException("Unknown product: " + sku));

        // Intentional architectural violation for the demo: Orders reaches into Catalog internals.
        BigDecimal unitPrice = PricingRules.priceFor(product.price(), tier);
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
