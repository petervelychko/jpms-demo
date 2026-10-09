module dev.demo.orders {
    requires dev.demo.catalog;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;

    exports dev.demo.orders.api;
}
