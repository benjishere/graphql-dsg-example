package tech.brodewicz.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultItemsService implements ItemsService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultItemsService.class);

    private final OrdersService ordersService;

    public DefaultItemsService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
}
