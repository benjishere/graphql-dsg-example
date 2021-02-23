package tech.brodewicz.dataloaders;

import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;
import tech.brodewicz.services.DefaultItemsService;
import tech.brodewicz.types.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "items")
public class ItemsDataLoader implements MappedBatchLoader<Integer, List<Item>> {

    private final DefaultItemsService itemsService;

    public ItemsDataLoader(DefaultItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @Override
    public CompletionStage<Map<Integer, List<Item>>> load(Set<Integer> keys) {
        return CompletableFuture.supplyAsync(() -> itemsService.itemsOfOrder(new ArrayList<>(keys)));
    }
}
