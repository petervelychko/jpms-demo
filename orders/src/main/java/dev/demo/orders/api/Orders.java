package dev.demo.orders.api;

import dev.demo.catalog.api.Catalog;
import dev.demo.orders.internal.DefaultOrderService;
import dev.demo.orders.internal.persistence.JsonOrderStore;

public final class Orders {
    private Orders() {
    }

    public static OrderService create(Catalog catalog) {
        return new DefaultOrderService(catalog, new JsonOrderStore());
    }
}
