package tech.brodewicz.types;

import java.util.List;

public class Order {

    private final Integer id;
    private List<Item> items;
    private final String createdAt;
    private Integer totalPrice;

    public Order(Integer id, String createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public List<Item> getItem() {
        return items;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }
}
