package class3.entity;

public enum SortByOptions {
    
    TIME_ENDING_SOON("Time: ending soonest"),
    TIME_ADDED_NEW("Time: newly listed"),
    LOWEST_PRICE_AND_SHIPPING_FIRST("Price + Shipping: lowest first"),
    HIGHEST_PRICE_AND_SHIPPING_FIRST("Price + Shipping: highest first"),
    NEAREST_DISTANCE("Distance: nearest first"),
    BEST_MATCH("Best match");

    private String value;

    SortByOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
