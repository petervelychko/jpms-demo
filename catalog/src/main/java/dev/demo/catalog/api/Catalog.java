package dev.demo.catalog.api;

import java.math.BigDecimal;
import java.util.Optional;

public interface Catalog {
    Optional<Product> find(String sku);

    BigDecimal priceFor(String sku, CustomerTier tier);
}
