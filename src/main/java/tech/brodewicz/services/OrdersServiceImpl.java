package tech.brodewicz.services;

import org.springframework.stereotype.Service;
import tech.brodewicz.types.Item;
import tech.brodewicz.types.Order;

import java.util.List;

@Service
public class OrdersServiceImpl implements  OrdersService{
    @Override
    public List<Order> orders() {
        return List.of(new Order(1, new Item(1, "Toyota Yaris", "The latest Toyota Yaris has more interior space and new styling, partly thanks to a new platform. A plug-in hybrid version could join the current hybrid models later, while more than one 'GR' spec Yaris hot hatch is being planned - this will include one hardcore model with over 250bhp, huge wheel arches and four-wheel drive.", 22199), "20-02-2021"),
                new Order(2, new Item(2, "Citroen C4", "Citroen has revealed a new C4 to face off against the Ford Focus and Vauxhall Astra, and it’ll have electric, petrol and diesel powertrains from launch. It’ll look completely different to the bland previous model, with crossover saloon-like styling. We think it looks excellent inside and out, with a more upmarket interior than the Citroen C4 Cactus, which this car will also replace.", 20990), "18-02-2021"),
                new Order(3, new Item(3, "Mercedes EQA", "After the Mercedes EQC, there’ll be an electric car a similar size to the Mercedes A-Class hatchback and Mercedes GLA SUV. The EQA will be Mercedes’ smallest electric car but will offer a large 60kWh battery and an electric motor that combine to produce 286bhp and 0-62mph in around five seconds. It’ll be a premium alternative to the Volkswagen ID.3, and should be able to travel around 250 miles between charges.", 35690), "05-01-2021"),
                new Order(4, new Item(4, "Skoda Octavia", "The Skoda Octavia is a very important car for the Czech company, and the latest version is more like the Skoda Superb. The new car will be more luxurious, slightly bigger and will have an engine range with multiple hybrid options.", 22390), "14-12-2020"),
                new Order(5, new Item(5, "Volkswagen ID.3", "The Volkswagen ID.3 is now on sale and first deliveries are scheduled for September. The first 30,000 cars will be high-spec ‘1st’ launch models, but some of these will need software updates later in the year to get the full list of technology.", 29995), "02-01-2021"),
                new Order(6, new Item(6, "Volvo V40", "The Volvo V40 will become a pseudo-SUV when the new model breaks cover later in 2020. It’ll take cues from the successful Volvo XC40 SUV, with raised ride height and plastic body cladding. Hybrid and electric versions will be available.", 25000), "17-02-2021"),
                new Order(7, new Item(7, "Hyundai i30", "It’s time for the Hyundai i30 range to get a midlife facelift and there are plenty of improvements. The styling changes aren’t massive but striking new LED elements in the headlights and restyled grilles are enough to make the i30 really stand out.", 17990), "05-02-2021"),
                new Order(8, new Item(8, "Kia Rio", "Kia has also updated its Rio hatchback, which rivals the Ford Fiesta and is a little bigger than the Picanto. It too gets the large eight-inch screen, and there’s a brand-new engine with mild-hybrid technology for the first time. There are LED headlights and new paint colours.", 13100), "21-01-2021"));
    }
}
