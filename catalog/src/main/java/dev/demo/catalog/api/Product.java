package dev.demo.catalog.api;

import java.math.BigDecimal;

public record Product(String sku, String name, BigDecimal price) {
}
