package tech.brodewicz.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.brodewicz.types.DgsConstants.TYPE;
import tech.brodewicz.types.Item;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultItemsService implements ItemsService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultItemsService.class);
    private final Map<Integer, List<Item>> items = new ConcurrentHashMap<>();
    private final OrdersService ordersService;

    public DefaultItemsService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostConstruct
    private void createItems() {

        ArrayList<Item> itemsArray = (ArrayList<Item>) List.of(
                new Item(0, "Toyota Yaris", TYPE.COMPACT, 22199),
                new Item(1, "Citroen C4", TYPE.CROSSOVER, 20990),
                new Item(2, "Mercedes EQA", TYPE.SUV, 35690),
                new Item(3, "Skoda Octavia", TYPE.COMPACT, 22390),
                new Item(4, "Volkswagen ID.3", TYPE.COMPACT, 29995),
                new Item(5, "Volvo V40", TYPE.CROSSOVER, 25000),
                new Item(6, "Hyundai i30", TYPE.COMPACT, 17990),
                new Item(7, "Kia Rio", TYPE.COMPACT, 13100));

        ordersService.orders().forEach(order -> {
                items.put(order.getId(), List.of(itemsArray.get(order.getId())));

        });
    }

    public List<Item> reviewsForShow(Integer orderId) {
        return items.get(orderId);
    }

}
