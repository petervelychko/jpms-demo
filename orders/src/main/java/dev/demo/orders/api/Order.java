package dev.demo.orders.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record Order(UUID id, List<OrderLine> lines, BigDecimal total) {
}
