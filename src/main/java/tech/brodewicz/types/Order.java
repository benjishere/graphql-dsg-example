package tech.brodewicz.types;

import java.util.List;

public class Order {

    private final Integer id;
    private final Item item;
    private final String createdAt;

    public Order(Integer id, Item item, String createdAt) {
        this.id = id;
        this.item = item;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
