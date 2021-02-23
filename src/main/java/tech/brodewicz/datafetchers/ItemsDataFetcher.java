package tech.brodewicz.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.dataloader.DataLoader;
import tech.brodewicz.dataloaders.ItemsDataLoader;
import tech.brodewicz.services.DefaultItemsService;
import tech.brodewicz.types.DgsConstants;
import tech.brodewicz.types.Item;
import tech.brodewicz.types.Order;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class ItemsDataFetcher {

    private final DefaultItemsService defaultItemsService;

    public ItemsDataFetcher(DefaultItemsService defaultItemsService) {
        this.defaultItemsService = defaultItemsService;
    }

    @DgsData(parentType = DgsConstants.ORDER.TYPE_NAME, field = DgsConstants.ORDER.Items)
    public CompletableFuture<List<Item>> items(DgsDataFetchingEnvironment dfe) {
        //Instead of loading a DataLoader by name, we can use the DgsDataFetchingEnvironment and pass in the DataLoader classname.
        DataLoader<Integer, List<Item>> ordersDataLoader = dfe.getDataLoader(ItemsDataLoader.class);

        //Because the items field is on Order, the getSource() method will return the Order instance.
        Order order = dfe.getSource();

        //Load the items from the DataLoader. This call is async and will be batched by the DataLoader mechanism.
        return ordersDataLoader.load(order.getId());
    }
}
