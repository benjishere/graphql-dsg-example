package tech.brodewicz.types;

public class Item {

    private final Integer id;
    private final String name;
    private final String desc;
    private final Integer price;

    public Item(Integer id, String name, String desc, Integer price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getPrice() {
        return price;
    }
}
