package dev.demo.orders.internal.persistence;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.demo.orders.api.Order;

public final class JsonOrderStore implements OrderStore {
    private final ObjectMapper mapper;

    public JsonOrderStore() {
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    @Override
    public void save(Order order) {
        var stored = new StoredOrder(order.id(), order.total());

        try {
            var json = mapper.writeValueAsString(stored);
            System.out.println("Persisted order as JSON: " + json);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Could not persist order", e);
        }
    }
}
