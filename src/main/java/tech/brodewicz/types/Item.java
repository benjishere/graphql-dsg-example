package tech.brodewicz.types;

import tech.brodewicz.types.DgsConstants.TYPE;

public class Item {

    private final Integer id;
    private final String name;
    private final TYPE type;
    private final Integer price;

    public Item(Integer id, String name, TYPE type, Integer price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public TYPE getType() {
        return type;
    }
}
