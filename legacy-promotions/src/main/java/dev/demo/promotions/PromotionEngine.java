package dev.demo.promotions;

import java.math.BigDecimal;

/**
 * Deliberately lives in a JAR without module-info.java.
 * The JAR manifest supplies Automatic-Module-Name so it can act as an automatic module.
 */
public final class PromotionEngine {
    private static final BigDecimal PROMOTION_FACTOR = new BigDecimal("0.95");

    public BigDecimal apply(BigDecimal price) {
        return price.multiply(PROMOTION_FACTOR);
    }
}
