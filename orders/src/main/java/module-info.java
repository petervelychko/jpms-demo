module dev.demo.orders {
    requires dev.demo.catalog;
    requires dev.demo.promotions;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;

    exports dev.demo.orders.api;

    opens dev.demo.orders.internal.persistence
            to com.fasterxml.jackson.databind;
}
