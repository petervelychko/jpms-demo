package dev.demo.catalog.internal;

import dev.demo.catalog.api.Catalog;
import dev.demo.catalog.api.CustomerTier;
import dev.demo.catalog.api.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public final class InMemoryCatalog implements Catalog {
    private final Map<String, Product> products = Map.of(
            "java-mug", new Product("java-mug", "Java Duke Mug", new BigDecimal("19.90")),
            "module-shirt", new Product("module-shirt", "JPMS T-Shirt", new BigDecimal("29.90"))
    );

    @Override
    public Optional<Product> find(String sku) {
        return Optional.ofNullable(products.get(sku));
    }

    @Override
    public BigDecimal priceFor(String sku, CustomerTier tier) {
        var product = find(sku)
                .orElseThrow(() -> new IllegalArgumentException("Unknown product: " + sku));
        return PricingRules.priceFor(product.price(), tier);
    }
}
