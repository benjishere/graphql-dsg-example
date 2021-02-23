package tech.brodewicz.types;

import java.lang.String;

public class DgsConstants {
    public static final String QUERY_TYPE = "Query";

    public static class QUERY {
        public static final String TYPE_NAME = "Query";

        public static final String Orders = "orders";
    }

    public static class ORDER {
        public static final String TYPE_NAME = "Order";

        public static final String Id = "id";

        public static final String Item = "item";

        public static final String CreatedAt = "createdAt";
    }

    public static class ITEM {
        public static final String TYPE_NAME = "Item";

        public static final String Name = "name";

        public static final String Desc = "desc";

        public static final String Price = "price";
    }

    public enum TYPE {
        COMPACT,
        CROSSOVER,
        SUV,
        PICK_UP
    }
}
