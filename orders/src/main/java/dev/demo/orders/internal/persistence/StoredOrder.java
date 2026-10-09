package dev.demo.orders.internal.persistence;

import java.math.BigDecimal;
import java.util.UUID;

final class StoredOrder {
    private UUID id;
    private BigDecimal total;

    StoredOrder() {
    }

    StoredOrder(UUID id, BigDecimal total) {
        this.id = id;
        this.total = total;
    }
}
