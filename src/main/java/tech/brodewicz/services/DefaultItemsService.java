package tech.brodewicz.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.brodewicz.types.DgsConstants.TYPE;
import tech.brodewicz.types.Item;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class DefaultItemsService implements ItemsService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultItemsService.class);
    private final Map<Integer, List<Item>> items = new ConcurrentHashMap<>();
    private final OrdersService ordersService;

    public DefaultItemsService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostConstruct
    private void createItems() {

        Random rand = new Random();
        List<Item> itemsArray = new ArrayList<>();
        itemsArray.addAll(List.of(
                new Item(0, "Toyota Yaris", TYPE.COMPACT, 22199),
                new Item(1, "Citroen C4", TYPE.CROSSOVER, 20990),
                new Item(2, "Mercedes EQA", TYPE.SUV, 35690),
                new Item(3, "Skoda Octavia", TYPE.COMPACT, 22390),
                new Item(4, "Volkswagen ID.3", TYPE.COMPACT, 29995),
                new Item(5, "Volvo V40", TYPE.CROSSOVER, 25000),
                new Item(6, "Hyundai i30", TYPE.COMPACT, 17990),
                new Item(7, "Kia Rio", TYPE.COMPACT, 13100)));

        ordersService.orders().forEach(order -> {
                List<Item> orderItems = new ArrayList<Item>();
                orderItems.add(itemsArray.get(rand.nextInt(itemsArray.size())));
                orderItems.add(itemsArray.get(rand.nextInt(itemsArray.size())));
                items.put(order.getId(), orderItems);
        });
    }

    public Map<Integer, List<Item>> itemsOfOrder(List<Integer> orderIds) {
        logger.info("Loading items for orders {}", orderIds.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        return items.entrySet().stream().filter(entry -> orderIds.contains(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
