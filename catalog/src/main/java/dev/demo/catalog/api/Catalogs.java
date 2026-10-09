package dev.demo.catalog.api;

import dev.demo.catalog.internal.InMemoryCatalog;

public final class Catalogs {
    private Catalogs() {
    }

    public static Catalog sample() {
        return new InMemoryCatalog();
    }
}
