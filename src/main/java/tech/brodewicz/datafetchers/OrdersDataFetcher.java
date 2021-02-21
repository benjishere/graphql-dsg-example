package tech.brodewicz.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import tech.brodewicz.services.OrdersService;
import tech.brodewicz.types.DgsConstants;
import tech.brodewicz.types.Order;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class OrdersDataFetcher {

    private final OrdersService ordersService;

    public OrdersDataFetcher(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Orders)
    public List<Order> orders(@InputArgument("orderId") Integer orderId) {
        if (orderId == null)
            return ordersService.orders();

        return ordersService.orders().stream().filter(s -> s.getId() == orderId).collect(Collectors.toList());
    }
}
