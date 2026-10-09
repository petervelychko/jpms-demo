package dev.demo.catalog.internal;

import dev.demo.catalog.api.CustomerTier;

import java.math.BigDecimal;

public final class PricingRules {
    private static final BigDecimal PREMIUM_FACTOR = new BigDecimal("0.90");

    private PricingRules() {
    }

    public static BigDecimal priceFor(BigDecimal price, CustomerTier tier) {
        return switch (tier) {
            case STANDARD -> price;
            case PREMIUM -> price.multiply(PREMIUM_FACTOR);
        };
    }
}
