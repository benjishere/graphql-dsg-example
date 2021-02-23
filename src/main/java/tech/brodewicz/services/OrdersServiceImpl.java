package tech.brodewicz.services;

import org.springframework.stereotype.Service;
import tech.brodewicz.types.Order;

import java.util.List;

@Service
public class OrdersServiceImpl implements  OrdersService {
    @Override
    public List<Order> orders() {
        return List.of(
                new Order(0, "20-02-2021"),
                new Order(1, "18-02-2021"),
                new Order(2, "05-01-2021"),
                new Order(3, "14-12-2020"),
                new Order(4, "02-01-2021"),
                new Order(5, "17-02-2021"),
                new Order(6, "05-02-2021"),
                new Order(7, "21-01-2021")
        );
    }
}
